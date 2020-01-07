package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.dto.UserDTO;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.model.SystemUserExample;

import java.util.List;

public interface SystemUserService {
    List<SystemUser> getManager();
    SystemUser getManagerById(Integer mID);
    UserDTO getUserDTO(String role, Integer from, Integer size, String... args);
    UserDTO getByExample(SystemUserExample userExample);
}
