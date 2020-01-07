package com.citi.portfolio.util;

import java.text.NumberFormat;

public class NumberFormatter {
    public Double format(Double number){
        if (number == null || number == 0.0)
            return number;
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(3);
        numberFormat.setGroupingUsed(false);
        String tmp = numberFormat.format(number);
        return new Double(tmp);
    }
}
