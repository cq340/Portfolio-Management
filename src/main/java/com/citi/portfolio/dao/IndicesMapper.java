package com.citi.portfolio.dao;

import com.citi.portfolio.model.Indices;
import com.citi.portfolio.model.IndicesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IndicesMapper {
    long countByExample(IndicesExample example);

    int deleteByExample(IndicesExample example);

    int deleteByPrimaryKey(Integer indiciesId);

    int insert(Indices record);

    int insertSelective(Indices record);

    List<Indices> selectByExample(IndicesExample example);

    Indices selectByPrimaryKey(Integer indiciesId);

    int updateByExampleSelective(@Param("record") Indices record, @Param("example") IndicesExample example);

    int updateByExample(@Param("record") Indices record, @Param("example") IndicesExample example);

    int updateByPrimaryKeySelective(Indices record);

    int updateByPrimaryKey(Indices record);
}