package com.citi.portfolio.dao;

import com.citi.portfolio.model.Stocks;
import com.citi.portfolio.model.StocksExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StocksMapper {
    long countByExample(StocksExample example);

    int deleteByExample(StocksExample example);

    int deleteByPrimaryKey(Integer stocksId);

    int insert(Stocks record);

    int insertSelective(Stocks record);

    List<Stocks> selectByExample(StocksExample example);

    Stocks selectByPrimaryKey(Integer stocksId);

    int updateByExampleSelective(@Param("record") Stocks record, @Param("example") StocksExample example);

    int updateByExample(@Param("record") Stocks record, @Param("example") StocksExample example);

    int updateByPrimaryKeySelective(Stocks record);

    int updateByPrimaryKey(Stocks record);
}