package com.citi.portfolio.dao;

import com.citi.portfolio.model.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by changqing on 2018/8/13.
 */
@Mapper
@Component
public interface UserDAO {

    @Select({"select * from SYSTEMUSER where USER_NAME=#{username} and PASSWORD=#{password}"})
    SystemUser checkLogin(@Param("username") String username, @Param("password") String password);
}