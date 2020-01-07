package com.citi.portfolio.dao;

import com.citi.portfolio.model.Commodities;
import com.citi.portfolio.model.CommoditiesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CommoditiesMapper {
    long countByExample(CommoditiesExample example);

    int deleteByExample(CommoditiesExample example);

    int deleteByPrimaryKey(Integer commoditiesId);

    int insert(Commodities record);

    int insertSelective(Commodities record);

    List<Commodities> selectByExample(CommoditiesExample example);

    Commodities selectByPrimaryKey(Integer commoditiesId);

    int updateByExampleSelective(@Param("record") Commodities record, @Param("example") CommoditiesExample example);

    int updateByExample(@Param("record") Commodities record, @Param("example") CommoditiesExample example);

    int updateByPrimaryKeySelective(Commodities record);

    int updateByPrimaryKey(Commodities record);
}