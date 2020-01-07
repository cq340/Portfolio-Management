package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Component
public class PortfolioDashboardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int startRow;

    protected int pageSize;

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PortfolioDashboardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPortIdIsNull() {
            addCriterion("PORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPortIdIsNotNull() {
            addCriterion("PORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPortIdEqualTo(Integer value) {
            addCriterion("PORT_ID =", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotEqualTo(Integer value) {
            addCriterion("PORT_ID <>", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThan(Integer value) {
            addCriterion("PORT_ID >", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PORT_ID >=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThan(Integer value) {
            addCriterion("PORT_ID <", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdLessThanOrEqualTo(Integer value) {
            addCriterion("PORT_ID <=", value, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdIn(List<Integer> values) {
            addCriterion("PORT_ID in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotIn(List<Integer> values) {
            addCriterion("PORT_ID not in", values, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdBetween(Integer value1, Integer value2) {
            addCriterion("PORT_ID between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andPortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PORT_ID not between", value1, value2, "portId");
            return (Criteria) this;
        }

        public Criteria andPortNameIsNull() {
            addCriterion("PORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPortNameIsNotNull() {
            addCriterion("PORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPortNameEqualTo(String value) {
            addCriterion("PORT_NAME =", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotEqualTo(String value) {
            addCriterion("PORT_NAME <>", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameGreaterThan(String value) {
            addCriterion("PORT_NAME >", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameGreaterThanOrEqualTo(String value) {
            addCriterion("PORT_NAME >=", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLessThan(String value) {
            addCriterion("PORT_NAME <", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLessThanOrEqualTo(String value) {
            addCriterion("PORT_NAME <=", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameLike(String value) {
            addCriterion("PORT_NAME like", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotLike(String value) {
            addCriterion("PORT_NAME not like", value, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameIn(List<String> values) {
            addCriterion("PORT_NAME in", values, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotIn(List<String> values) {
            addCriterion("PORT_NAME not in", values, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameBetween(String value1, String value2) {
            addCriterion("PORT_NAME between", value1, value2, "portName");
            return (Criteria) this;
        }

        public Criteria andPortNameNotBetween(String value1, String value2) {
            addCriterion("PORT_NAME not between", value1, value2, "portName");
            return (Criteria) this;
        }

        public Criteria andPositionDateIsNull() {
            addCriterion("POSITION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPositionDateIsNotNull() {
            addCriterion("POSITION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDateEqualTo(Date value) {
            addCriterionForJDBCDate("POSITION_DATE =", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("POSITION_DATE <>", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("POSITION_DATE >", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("POSITION_DATE >=", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateLessThan(Date value) {
            addCriterionForJDBCDate("POSITION_DATE <", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("POSITION_DATE <=", value, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateIn(List<Date> values) {
            addCriterionForJDBCDate("POSITION_DATE in", values, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("POSITION_DATE not in", values, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("POSITION_DATE between", value1, value2, "positionDate");
            return (Criteria) this;
        }

        public Criteria andPositionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("POSITION_DATE not between", value1, value2, "positionDate");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("CASH is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("CASH is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(Double value) {
            addCriterion("CASH =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(Double value) {
            addCriterion("CASH <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(Double value) {
            addCriterion("CASH >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(Double value) {
            addCriterion("CASH >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(Double value) {
            addCriterion("CASH <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(Double value) {
            addCriterion("CASH <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<Double> values) {
            addCriterion("CASH in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<Double> values) {
            addCriterion("CASH not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(Double value1, Double value2) {
            addCriterion("CASH between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(Double value1, Double value2) {
            addCriterion("CASH not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andStockPriceIsNull() {
            addCriterion("STOCK_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andStockPriceIsNotNull() {
            addCriterion("STOCK_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andStockPriceEqualTo(Double value) {
            addCriterion("STOCK_PRICE =", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotEqualTo(Double value) {
            addCriterion("STOCK_PRICE <>", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceGreaterThan(Double value) {
            addCriterion("STOCK_PRICE >", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("STOCK_PRICE >=", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceLessThan(Double value) {
            addCriterion("STOCK_PRICE <", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceLessThanOrEqualTo(Double value) {
            addCriterion("STOCK_PRICE <=", value, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceIn(List<Double> values) {
            addCriterion("STOCK_PRICE in", values, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotIn(List<Double> values) {
            addCriterion("STOCK_PRICE not in", values, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceBetween(Double value1, Double value2) {
            addCriterion("STOCK_PRICE between", value1, value2, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andStockPriceNotBetween(Double value1, Double value2) {
            addCriterion("STOCK_PRICE not between", value1, value2, "stockPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNull() {
            addCriterion("COMMODITY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNotNull() {
            addCriterion("COMMODITY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceEqualTo(Double value) {
            addCriterion("COMMODITY_PRICE =", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotEqualTo(Double value) {
            addCriterion("COMMODITY_PRICE <>", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThan(Double value) {
            addCriterion("COMMODITY_PRICE >", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("COMMODITY_PRICE >=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThan(Double value) {
            addCriterion("COMMODITY_PRICE <", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThanOrEqualTo(Double value) {
            addCriterion("COMMODITY_PRICE <=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIn(List<Double> values) {
            addCriterion("COMMODITY_PRICE in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotIn(List<Double> values) {
            addCriterion("COMMODITY_PRICE not in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceBetween(Double value1, Double value2) {
            addCriterion("COMMODITY_PRICE between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotBetween(Double value1, Double value2) {
            addCriterion("COMMODITY_PRICE not between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceIsNull() {
            addCriterion("INI_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andIniPriceIsNotNull() {
            addCriterion("INI_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andIniPriceEqualTo(Double value) {
            addCriterion("INI_PRICE =", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceNotEqualTo(Double value) {
            addCriterion("INI_PRICE <>", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceGreaterThan(Double value) {
            addCriterion("INI_PRICE >", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("INI_PRICE >=", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceLessThan(Double value) {
            addCriterion("INI_PRICE <", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceLessThanOrEqualTo(Double value) {
            addCriterion("INI_PRICE <=", value, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceIn(List<Double> values) {
            addCriterion("INI_PRICE in", values, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceNotIn(List<Double> values) {
            addCriterion("INI_PRICE not in", values, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceBetween(Double value1, Double value2) {
            addCriterion("INI_PRICE between", value1, value2, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andIniPriceNotBetween(Double value1, Double value2) {
            addCriterion("INI_PRICE not between", value1, value2, "iniPrice");
            return (Criteria) this;
        }

        public Criteria andPortValueIsNull() {
            addCriterion("PORT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPortValueIsNotNull() {
            addCriterion("PORT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPortValueEqualTo(Double value) {
            addCriterion("PORT_VALUE =", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueNotEqualTo(Double value) {
            addCriterion("PORT_VALUE <>", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueGreaterThan(Double value) {
            addCriterion("PORT_VALUE >", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueGreaterThanOrEqualTo(Double value) {
            addCriterion("PORT_VALUE >=", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueLessThan(Double value) {
            addCriterion("PORT_VALUE <", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueLessThanOrEqualTo(Double value) {
            addCriterion("PORT_VALUE <=", value, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueIn(List<Double> values) {
            addCriterion("PORT_VALUE in", values, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueNotIn(List<Double> values) {
            addCriterion("PORT_VALUE not in", values, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueBetween(Double value1, Double value2) {
            addCriterion("PORT_VALUE between", value1, value2, "portValue");
            return (Criteria) this;
        }

        public Criteria andPortValueNotBetween(Double value1, Double value2) {
            addCriterion("PORT_VALUE not between", value1, value2, "portValue");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}