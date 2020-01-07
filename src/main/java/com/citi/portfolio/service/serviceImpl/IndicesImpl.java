package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.IndicesMapper;
import com.citi.portfolio.model.Indices;
import com.citi.portfolio.model.IndicesExample;
import com.citi.portfolio.service.serviceInterface.IndicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IndicesImpl implements IndicesService {
    @Autowired
    private IndicesMapper indicesMapper;
    @Autowired
    private IndicesExample indicesExample;

    /**
     * Select all indices according to the date
     * @return
     */
    @Override
    public List<Indices> get(Date date) {
        IndicesExample.Criteria criteria = indicesExample.createCriteria();
        criteria.andIndicesDateEqualTo(date);
        List<Indices> indices = indicesMapper.selectByExample(indicesExample);
        for (Indices tmp :
                indices) {
            Double chg = tmp.getChg();
            String changeRate = NumberFormat.getInstance().format(chg * 100) + "%";
            tmp.setChangeRate(changeRate);
            if (chg<0)
                tmp.setX(false);
            else {
                tmp.setChangeRate("+" + changeRate);
                tmp.setX(true);
            }
        }
        return indices;
    }
}
