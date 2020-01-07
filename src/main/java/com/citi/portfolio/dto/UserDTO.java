package com.citi.portfolio.dto;

import com.citi.portfolio.model.SystemUser;

import java.util.List;

public class UserDTO {
    private List<SystemUser> users;
    private Long size;

    public List<SystemUser> getUsers() {
        return users;
    }

    public void setUsers(List<SystemUser> users) {
        this.users = users;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
