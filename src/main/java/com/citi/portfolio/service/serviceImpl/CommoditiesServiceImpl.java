package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.CommoditiesMapper;
import com.citi.portfolio.model.Commodities;
import com.citi.portfolio.model.CommoditiesExample;
import com.citi.portfolio.service.serviceInterface.CommoditiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommoditiesServiceImpl implements CommoditiesService {
    @Autowired
    private CommoditiesMapper commoditiesMapper;
    @Override
    public Double getPriceByDate(String name, Date date) {
        CommoditiesExample commoditiesExample = new CommoditiesExample();
        CommoditiesExample.Criteria criteria = commoditiesExample.createCriteria();
        criteria.andCommDateEqualTo(date);
        criteria.andCommoditiesNameEqualTo(name);
        List<Commodities> commodities = commoditiesMapper.selectByExample(commoditiesExample);
        if (commodities != null && commodities.size() == 1)
            return commodities.get(0).getPrice();
        return null;
    }

    @Override
    public List<Double> getPriceTrend(String name, Date startDate, Date endDate) {
        List<Double> list = new ArrayList<>();
        CommoditiesExample commoditiesExample = new CommoditiesExample();
        CommoditiesExample.Criteria criteria = commoditiesExample.createCriteria();
        criteria.andCommoditiesNameEqualTo(name);
        criteria.andCommDateBetween(startDate,endDate);
        List<Commodities> commodities = commoditiesMapper.selectByExample(commoditiesExample);
        for (Commodities commodity : commodities) {
            list.add(commodity.getPrice());
        }
        return list;
    }

    @Override
    public List<Commodities> getByName(String name) {
        CommoditiesExample commoditiesExample = new CommoditiesExample();
        CommoditiesExample.Criteria criteria = commoditiesExample.createCriteria();
        criteria.andCommoditiesNameLike("%"+name+"%");
        List<Commodities> list=commoditiesMapper.selectByExample(commoditiesExample);
        return list;
    }
}
