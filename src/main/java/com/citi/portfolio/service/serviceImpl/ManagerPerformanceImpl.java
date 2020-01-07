package com.citi.portfolio.service.serviceImpl;

import com.citi.portfolio.dto.PerformanceDTO;
import com.citi.portfolio.dto.UserDTO;
import com.citi.portfolio.model.ManagerPerformance;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.SystemUser;
import com.citi.portfolio.service.serviceInterface.PortfolioService;
import com.citi.portfolio.service.serviceInterface.ManagerPerformanceService;
import com.citi.portfolio.service.serviceInterface.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class ManagerPerformanceImpl implements ManagerPerformanceService {
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private SystemUserService systemUserService;

    /**
     * get performance by manager's id
     *
     * @return
     */
    @Override
    public ManagerPerformance getPerformance(Integer mID) {
        SystemUser manager = systemUserService.getManagerById(mID);
        if (manager == null)
            return null;
        ManagerPerformance managerPerformance = new ManagerPerformance();
        Double initValue = getManagerInitValue(manager);
        Double currentValue = getCurrentValue(manager);
        Double amount = currentValue - initValue;

        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String percent = numberFormat.format(amount / initValue * 100) + "%";
        managerPerformance.setManager(manager);
        managerPerformance.setInitValue(initValue);
        managerPerformance.setCurrentValue(currentValue);
        managerPerformance.setAmount(amount);
        managerPerformance.setPercent(percent);
        return managerPerformance;
    }

    @Override
    public Double getManagerInitValue(SystemUser manager) {
        List<Portfolio> portfolios = portfolioService.getByManager(manager.getUserId(), null, null).getPortfolios();
        Double initValue = 0.0;
        for (Portfolio portfolio :
                portfolios) {
            Double tmp = portfolioService.getInitValue(portfolio);
            if (tmp != null)
                initValue += tmp;
        }
        return initValue;
    }

    /**
     * The value already count the cash of portfolio
     *
     * @param manager
     * @return
     */
    @Override
    public Double getCurrentValue(SystemUser manager) {
        List<Portfolio> portfolios = portfolioService.getByManager(manager.getUserId(), null, null).getPortfolios();
        Double value = 0.0;
        for (Portfolio portfolio :
                portfolios) {
            Double tmp = portfolioService.calValue(portfolio);
            if (tmp != null)
                value += tmp;
        }
        return value;
    }

    @Override
    public PerformanceDTO getPerformance(Integer from, Integer size, String... args) {
        //get all managers
        UserDTO managerDTO = systemUserService.getUserDTO("manager", from, size, args);
        List<SystemUser> managers = managerDTO.getUsers();
        List<ManagerPerformance> performances = new LinkedList<>();
        //get managers' performance one by one
        for (SystemUser manager :
                managers) {
            ManagerPerformance performance = getPerformance(manager.getUserId());
            performances.add(performance);
        }
        PerformanceDTO performanceDTO = new PerformanceDTO();
        performanceDTO.setManagerPerformances(performances);
        performanceDTO.setSize(managerDTO.getSize());
        return performanceDTO;
    }

}
