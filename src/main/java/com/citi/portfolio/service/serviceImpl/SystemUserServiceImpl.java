package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dao.SystemUserMapper;
import com.citi.portfolio.dto.UserDTO;
import com.citi.portfolio.model.CommoditiesExample;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.model.SystemUserExample;
import com.citi.portfolio.service.serviceInterface.SystemUserService;
import com.citi.portfolio.util.ExampleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public List<SystemUser> getManager() {
        SystemUserExample systemUserExample = new SystemUserExample();
        systemUserExample.createCriteria().andRoleEqualTo("manager");
        return systemUserMapper.selectByExample(systemUserExample);
    }

    @Override
    public SystemUser getManagerById(Integer mID) {
        SystemUserExample systemUserExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = systemUserExample.createCriteria();
        criteria.andRoleEqualTo("manager");
        criteria.andUserIdEqualTo(mID);
        List<SystemUser> managers = systemUserMapper.selectByExample(systemUserExample);
        if (managers != null && managers.size()==1)
            return managers.get(0);
        return null;
    }

    @Override
    public UserDTO getUserDTO(String role, Integer from, Integer size, String... args) {
        SystemUserExample userExample = new SystemUserExample();
        SystemUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andRoleEqualTo(role);
        //ordered the result
        String order = new ExampleFormatter<String>().formatSequence(args);
        if (order != null && !order.trim().equals(""))
            userExample.setOrderByClause(order);
        //paging
        userExample.setStartRow(from);
        userExample.setPageSize(size);
        return getByExample(userExample);
    }

    /**
     * return DTO model
     * @param userExample
     * @return
     */
    @Override
    public UserDTO getByExample(SystemUserExample userExample) {
        List<SystemUser> users = systemUserMapper.selectByExample(userExample);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsers(users);
        userDTO.setSize(systemUserMapper.countByExample(userExample));
        return userDTO;
    }
}
