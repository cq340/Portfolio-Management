package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.ManagerPortfolioMapper;
import com.citi.portfolio.dao.PortfolioMapper;
import com.citi.portfolio.dao.PositionMapper;
import com.citi.portfolio.dto.PortfolioDTO;
import com.citi.portfolio.model.*;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.portfolio.service.serviceInterface.PositionService;
import com.citi.portfolio.util.ExampleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    private PortfolioMapper portfolioMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ManagerPortfolioMapper managerPortfolioMapper;


    /**
     * Calculate current value of all positions
     * included cash
     * @param portfolio
     * @return
     */
    @Override
    public Double calValue(Portfolio portfolio) {
        if (portfolio == null)
            return null;
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andPortIdEqualTo(portfolio.getPortId());
        Double value = 0.0;
        List<Position> positions = positionMapper.selectByExample(positionExample);
        for (Position position :
                positions) {
            value += positionService.calValue(position);
        }
        value += portfolio.getCash();
        return value;
    }

    /**
     * Get init value of portfolio
     * @param portfolio
     * @return
     */
    @Override
    public Double getInitValue(Portfolio portfolio) {
        if (portfolio == null)
            return null;
        return portfolio.getPortValue();
    }

    /**
     * Add element by the properties of object
     * insert record to the manager_portfolio table as well
     * @param portfolio
     * @return
     */
    @Override
    public void add(Portfolio portfolio) {
        Date date = new Date();
        portfolio.setPortDate(date);
        portfolio.setCash(portfolio.getCash());
        portfolio.setPortValue(portfolio.getCash());
        portfolioMapper.insert(portfolio);
        //since the id will crease itself,
        //should get the id
        PortfolioExample portfolioExample = new PortfolioExample();
        PortfolioExample.Criteria criteria = portfolioExample.createCriteria();
        criteria.andPortNameEqualTo(portfolio.getPortName());
        portfolioExample.setOrderByClause("port_name , port_id desc");
        List<Portfolio> portfolios = portfolioMapper.selectByExample(portfolioExample);
        if (portfolios != null)
            portfolio = portfolios.get(0);
        else
            return;
        //insert record
        ManagerPortfolio record = new ManagerPortfolio();
        record.setManagerId(portfolio.getManagerId());
        record.setPortId(portfolio.getPortId());
        record.setStartDate(date);
        managerPortfolioMapper.insert(record);
    }

    /**
     * update the cash of portfolio to new cash value
     * @param portfolio
     * @param cash
     */
    @Override
    public void updateCash(Portfolio portfolio, Double cash) {
        PortfolioExample portfolioExample = new PortfolioExample();
        PortfolioExample.Criteria criteria = portfolioExample.createCriteria();
        criteria.andPortIdEqualTo(portfolio.getPortId());
        portfolio.setCash(cash);
        portfolioMapper.updateByExample(portfolio,portfolioExample);
    }

    /**
     * change the manager of the portfolio
     * and insert record to manager_portfolio table
     * @param formerID former manager id
     * @param curId current manager id
     * @param portId portfolio id
     */
    @Override
    @Transactional
    public void changeManager(Integer formerID, Integer curId, Integer portId) {
        //update manager of portfolio
        Portfolio portfolio = getById(portId);
        portfolio.setManagerId(curId);
        PortfolioExample portfolioExample = new PortfolioExample();
        portfolioExample.createCriteria().andPortIdEqualTo(portId);
        portfolioMapper.updateByExample(portfolio,portfolioExample);
        //update record's end time since manager changed
        Date date = new Date();
        ManagerPortfolioExample example = new ManagerPortfolioExample();
        ManagerPortfolioExample.Criteria criteria = example.createCriteria();
        criteria.andPortIdEqualTo(portId);
        criteria.andManagerIdEqualTo(formerID);
        criteria.andEndDateIsNull();//it has to be null
        List<ManagerPortfolio> managerPortfolios = managerPortfolioMapper.selectByExample(example);
        if (managerPortfolios != null && managerPortfolios.size()==1){
            ManagerPortfolio managerPortfolio = managerPortfolios.get(0);
            managerPortfolio.setEndDate(date);
            managerPortfolioMapper.updateByExample(managerPortfolio,example);
        }else
            return;
        //insert record to manager_portfolio table
        ManagerPortfolio record = new ManagerPortfolio();
        record.setManagerId(curId);
        record.setPortId(portId);
        record.setStartDate(date);
        managerPortfolioMapper.insert(record);
    }

    /**
     * spend cash of portfolio according to position's value when it bought
     * @param position
     * @return
     */
    @Override
    public Boolean calCash(Position position) {
        Double value = positionService.calInitValue(position);
        Portfolio portfolio = getById(position.getPortId());
        Double cash = portfolio.getCash();
        if (cash < value)
            return false;
        updateCash(portfolio,cash - value);
        return true;
    }

    @Override
    public PortfolioDTO getAll() {
        return getByExample(new PortfolioExample());
    }

    /**
     * to convert to DTO model
     * @param portfolioExample
     * @return
     */
    @Override
    public PortfolioDTO getByExample(PortfolioExample portfolioExample) {
        List<Portfolio> portfolios = portfolioMapper.selectByExample(portfolioExample);
        //Calculate every portfolio's value
        for (Portfolio portfolio :
                portfolios) {
            Double value = calValue(portfolio);
            portfolio.setCurrentValue(value);
            //calculate percent
            Double amount = value - portfolio.getPortValue();
            portfolio.setAmount(amount);
            String percent = NumberFormat.getInstance().format(amount * 100) + "%";
            portfolio.setPercent(percent);
            if (amount > 0)
                portfolio.setPercent("+" + percent);
        }
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setPortfolios(portfolios);
        portfolioDTO.setSize(portfolioMapper.countByExample(portfolioExample));
        return portfolioDTO;
    }

    /**
     * Get portfolios by manager's id
     * @param mID
     * @return
     */
    @Override
    public PortfolioDTO getByManager(Integer mID, Integer from, Integer size,String... args) {
        PortfolioExample portfolioExample = new PortfolioExample();
        PortfolioExample.Criteria criteria = portfolioExample.createCriteria();
        criteria.andManagerIdEqualTo(mID);
        //ordered the result
        String order = new ExampleFormatter<String>().formatSequence(args);
        if (order != null && !order.trim().equals(""))
            portfolioExample.setOrderByClause(order);
        //paging
        if (from != null)
            portfolioExample.setStartRow(from);
        if (size != null)
            portfolioExample.setPageSize(size);
        return getByExample(portfolioExample);
    }

    @Override
    public Portfolio getById(Integer portId) {
        PortfolioExample portfolioExample = new PortfolioExample();
        portfolioExample.createCriteria().andPortIdEqualTo(portId);
        List<Portfolio> portfolios = portfolioMapper.selectByExample(portfolioExample);
        if (portfolios.size()!=1)
            return null;
        Portfolio portfolio = portfolios.get(0);
        return portfolio;
    }
}
