package com.citi.portfolio.dao;

import com.citi.portfolio.model.PortfolioDashboard;
import com.citi.portfolio.model.PortfolioDashboardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PortfolioDashboardMapper {
    long countByExample(PortfolioDashboardExample example);

    int deleteByExample(PortfolioDashboardExample example);

    int insert(PortfolioDashboard record);

    int insertSelective(PortfolioDashboard record);

    List<PortfolioDashboard> selectByExample(PortfolioDashboardExample example);

    int updateByExampleSelective(@Param("record") PortfolioDashboard record, @Param("example") PortfolioDashboardExample example);

    int updateByExample(@Param("record") PortfolioDashboard record, @Param("example") PortfolioDashboardExample example);
}