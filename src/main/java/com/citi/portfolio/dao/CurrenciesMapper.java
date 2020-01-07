package com.citi.portfolio.dao;

import com.citi.portfolio.model.Currencies;
import com.citi.portfolio.model.CurrenciesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CurrenciesMapper {
    long countByExample(CurrenciesExample example);

    int deleteByExample(CurrenciesExample example);

    int deleteByPrimaryKey(Integer currenciesId);

    int insert(Currencies record);

    int insertSelective(Currencies record);

    List<Currencies> selectByExample(CurrenciesExample example);

    Currencies selectByPrimaryKey(Integer currenciesId);

    int updateByExampleSelective(@Param("record") Currencies record, @Param("example") CurrenciesExample example);

    int updateByExample(@Param("record") Currencies record, @Param("example") CurrenciesExample example);

    int updateByPrimaryKeySelective(Currencies record);

    int updateByPrimaryKey(Currencies record);
}