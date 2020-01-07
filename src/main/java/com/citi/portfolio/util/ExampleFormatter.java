package com.citi.portfolio.util;

public class ExampleFormatter<T> {
    public T format(T t, Integer from, Integer size, String... args){
        //ordered the result
        String order = "";
        for (String tmp :
                args) {
            if (tmp != null && !tmp.equals(""))
                order += " " + tmp;
        }
//        if (order != null && !order.trim().equals(""))
//            t.setOrderByClause(order);
//        //paging
//        t.setStartRow(from);
//        t.setPageSize(size);
        return t;
    }

    public String formatSequence(String args[]){
        //ordered the result
        String order = "";
        for (String tmp :
                args) {
            if (tmp != null && !tmp.equals(""))
                order += " " + tmp;
        }
        return order;
    }
}
