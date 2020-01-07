package com.citi.portfolio.dao;

import com.citi.portfolio.model.ManagerPortfolio;
import com.citi.portfolio.model.ManagerPortfolioExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ManagerPortfolioMapper {
    long countByExample(ManagerPortfolioExample example);

    int deleteByExample(ManagerPortfolioExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManagerPortfolio record);

    int insertSelective(ManagerPortfolio record);

    List<ManagerPortfolio> selectByExample(ManagerPortfolioExample example);

    ManagerPortfolio selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManagerPortfolio record, @Param("example") ManagerPortfolioExample example);

    int updateByExample(@Param("record") ManagerPortfolio record, @Param("example") ManagerPortfolioExample example);

    int updateByPrimaryKeySelective(ManagerPortfolio record);

    int updateByPrimaryKey(ManagerPortfolio record);
}