package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.PositionMapper;
import com.citi.portfolio.dto.PositionDTO;
import com.citi.portfolio.model.*;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.portfolio.service.serviceInterface.PositionService;
import com.citi.portfolio.service.serviceInterface.ItemService;
import com.citi.portfolio.util.ExampleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PortfolioService portfolioService;

    /**
     * add a position
     * get init price of position according to type&init_date
     * @param position
     * @param type
     */
    @Override
    public Boolean add(Position position, String type) {
        Double initPrice = itemService.getPriceByDate(type,position.getItemName(),position.getPositionDate());
        position.setIniPrice(initPrice);
        //cal cash in case cash cant cover the spend value
        if (portfolioService.calCash(position)) {
            positionMapper.insert(position);
            return true;
        }
        return false;
    }

    /**
     * sell will update qty of position
     * and add cash to portfolio
     * @param position
     * @param type
     * @return
     */
    @Override
    public Boolean sell(Position position, String type) {
        Integer sellQty = position.getQty();
        Date date = position.getPositionDate();
        position = getById(position.getPositionId());
        //get current price of position
        Double price = itemService.getPriceByDate(type,position.getItemName(),date);
        //sell only allows suitable qty
        if (!(position.getQty() < sellQty)) {
            //if suitable, change position's qty
            position.setQty(position.getQty() - sellQty);
            update(position);
            //add cash to portfolio
            Portfolio portfolio = portfolioService.getById(position.getPortId());
            Double cash = portfolio.getCash();
            portfolioService.updateCash(portfolio,cash + price * sellQty);
            return true;
        }
        return  false;
    }

    /**
     * Get all positions according to portfolio_id
     * @param portId
     * @return
     */
    @Override
    public PositionDTO getPositions(Integer portId, Integer from, Integer size, String... args) {
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andPortIdEqualTo(portId);
        //ordered the result
        String order = new ExampleFormatter<String>().formatSequence(args);
        if (order != null && !order.trim().equals(""))
            positionExample.setOrderByClause(order);
        //paging
        positionExample.setStartRow(from);
        positionExample.setPageSize(size);
        return getByExample(positionExample);
    }
    /**
     * Calculate the current value of single position
     * Not Used
     * @param position
     * @return
     */
    @Override
    public Double calValue(Position position) {
        Double curPrice = 0.0;
        Integer qty = 0;
        //get current price before calculate
        position.setCurPrice(getCurPrice(position));
        if (position.getCurPrice() != null && !(position.getCurPrice()<0))
            curPrice = position.getCurPrice();
        if (position.getQty() != null && !(position.getQty()<0))
            qty = position.getQty();
        Double value = curPrice * qty;
        return value;
    }

    @Override
    public Double calInitValue(Position position) {
        Double iniPrice = position.getIniPrice();
        Integer qty = position.getQty();
        if (iniPrice == null)
            iniPrice = 0.0;
        if (qty == null)
            qty = 0;
        Double initValue = iniPrice * qty;
        return initValue;
    }

    @Override
    public Double getCurPrice(Position position) {
        //get price according to position's name
        String type = "stocks";
        Date date = new Date();
        Double price = itemService.getPriceByDate(type, position.getItemName(), date);
        if (price == null) {
            type = "commodities";
            price = itemService.getPriceByDate(type, position.getItemName(), date);
            position.setType(type);
        }else
            position.setType(type);
        return price;
    }

    @Override
    public Position getById(Integer positionId) {
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andPositionIdEqualTo(positionId);
        List<Position> positions = positionMapper.selectByExample(positionExample);
        if (positions.size()!=1)
            return null;
        return positions.get(0);
    }

    /**
     * encapsulation position's data to DTO object to view
     * @param positionExample
     * @return
     */
    @Override
    public PositionDTO getByExample(PositionExample positionExample) {
        List<Position> positions = positionMapper.selectByExample(positionExample);
        for (Position position :
                positions) {
            //get price according to position's name
            Double price = getCurPrice(position);
            position.setCurPrice(price);
            //get total value to return to page
            position.setTotalValue(calValue(position));
        }
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setPositions(positions);
        positionDTO.setSize(positionMapper.countByExample(positionExample));
        return positionDTO;
    }

    private void update(Position position){
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andPositionIdEqualTo(position.getPositionId());
        positionMapper.updateByExample(position,positionExample);
    }

}
