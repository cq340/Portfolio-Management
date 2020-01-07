package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

@Component
public class SystemUser {
    private Integer userId;

    private Double iniMoney;

    private String userName;

    private Integer tel;

    private String role;

    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getIniMoney() {
        return iniMoney;
    }

    public void setIniMoney(Double iniMoney) {
        this.iniMoney = iniMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}