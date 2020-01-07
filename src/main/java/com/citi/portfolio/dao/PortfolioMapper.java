package com.citi.portfolio.dao;

import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PortfolioMapper {
    long countByExample(PortfolioExample example);

    int deleteByExample(PortfolioExample example);

    int deleteByPrimaryKey(Integer portId);

    int insert(Portfolio record);

    int insertSelective(Portfolio record);

    List<Portfolio> selectByExample(PortfolioExample example);

    Portfolio selectByPrimaryKey(Integer portId);

    int updateByExampleSelective(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    int updateByExample(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    int updateByPrimaryKeySelective(Portfolio record);

    int updateByPrimaryKey(Portfolio record);
}