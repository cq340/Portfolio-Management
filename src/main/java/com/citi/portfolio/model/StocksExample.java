package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Component
public class StocksExample {
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

    public StocksExample() {
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

        public Criteria andStocksIdIsNull() {
            addCriterion("STOCKS_ID is null");
            return (Criteria) this;
        }

        public Criteria andStocksIdIsNotNull() {
            addCriterion("STOCKS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStocksIdEqualTo(Integer value) {
            addCriterion("STOCKS_ID =", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdNotEqualTo(Integer value) {
            addCriterion("STOCKS_ID <>", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdGreaterThan(Integer value) {
            addCriterion("STOCKS_ID >", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("STOCKS_ID >=", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdLessThan(Integer value) {
            addCriterion("STOCKS_ID <", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdLessThanOrEqualTo(Integer value) {
            addCriterion("STOCKS_ID <=", value, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdIn(List<Integer> values) {
            addCriterion("STOCKS_ID in", values, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdNotIn(List<Integer> values) {
            addCriterion("STOCKS_ID not in", values, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdBetween(Integer value1, Integer value2) {
            addCriterion("STOCKS_ID between", value1, value2, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksIdNotBetween(Integer value1, Integer value2) {
            addCriterion("STOCKS_ID not between", value1, value2, "stocksId");
            return (Criteria) this;
        }

        public Criteria andStocksNameIsNull() {
            addCriterion("STOCKS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStocksNameIsNotNull() {
            addCriterion("STOCKS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStocksNameEqualTo(String value) {
            addCriterion("STOCKS_NAME =", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameNotEqualTo(String value) {
            addCriterion("STOCKS_NAME <>", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameGreaterThan(String value) {
            addCriterion("STOCKS_NAME >", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameGreaterThanOrEqualTo(String value) {
            addCriterion("STOCKS_NAME >=", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameLessThan(String value) {
            addCriterion("STOCKS_NAME <", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameLessThanOrEqualTo(String value) {
            addCriterion("STOCKS_NAME <=", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameLike(String value) {
            addCriterion("STOCKS_NAME like", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameNotLike(String value) {
            addCriterion("STOCKS_NAME not like", value, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameIn(List<String> values) {
            addCriterion("STOCKS_NAME in", values, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameNotIn(List<String> values) {
            addCriterion("STOCKS_NAME not in", values, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameBetween(String value1, String value2) {
            addCriterion("STOCKS_NAME between", value1, value2, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksNameNotBetween(String value1, String value2) {
            addCriterion("STOCKS_NAME not between", value1, value2, "stocksName");
            return (Criteria) this;
        }

        public Criteria andStocksDateIsNull() {
            addCriterion("STOCKS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStocksDateIsNotNull() {
            addCriterion("STOCKS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStocksDateEqualTo(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE =", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE <>", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateGreaterThan(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE >", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE >=", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateLessThan(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE <", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STOCKS_DATE <=", value, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateIn(List<Date> values) {
            addCriterionForJDBCDate("STOCKS_DATE in", values, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("STOCKS_DATE not in", values, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STOCKS_DATE between", value1, value2, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andStocksDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STOCKS_DATE not between", value1, value2, "stocksDate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNull() {
            addCriterion("OPEN_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNotNull() {
            addCriterion("OPEN_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceEqualTo(Double value) {
            addCriterion("OPEN_PRICE =", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotEqualTo(Double value) {
            addCriterion("OPEN_PRICE <>", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThan(Double value) {
            addCriterion("OPEN_PRICE >", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("OPEN_PRICE >=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThan(Double value) {
            addCriterion("OPEN_PRICE <", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThanOrEqualTo(Double value) {
            addCriterion("OPEN_PRICE <=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIn(List<Double> values) {
            addCriterion("OPEN_PRICE in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotIn(List<Double> values) {
            addCriterion("OPEN_PRICE not in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceBetween(Double value1, Double value2) {
            addCriterion("OPEN_PRICE between", value1, value2, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotBetween(Double value1, Double value2) {
            addCriterion("OPEN_PRICE not between", value1, value2, "openPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNull() {
            addCriterion("HIGH_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNotNull() {
            addCriterion("HIGH_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andHighPriceEqualTo(Double value) {
            addCriterion("HIGH_PRICE =", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotEqualTo(Double value) {
            addCriterion("HIGH_PRICE <>", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThan(Double value) {
            addCriterion("HIGH_PRICE >", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("HIGH_PRICE >=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThan(Double value) {
            addCriterion("HIGH_PRICE <", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThanOrEqualTo(Double value) {
            addCriterion("HIGH_PRICE <=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceIn(List<Double> values) {
            addCriterion("HIGH_PRICE in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotIn(List<Double> values) {
            addCriterion("HIGH_PRICE not in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceBetween(Double value1, Double value2) {
            addCriterion("HIGH_PRICE between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotBetween(Double value1, Double value2) {
            addCriterion("HIGH_PRICE not between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNull() {
            addCriterion("LOW_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("LOW_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(Double value) {
            addCriterion("LOW_PRICE =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(Double value) {
            addCriterion("LOW_PRICE <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(Double value) {
            addCriterion("LOW_PRICE >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("LOW_PRICE >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(Double value) {
            addCriterion("LOW_PRICE <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(Double value) {
            addCriterion("LOW_PRICE <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<Double> values) {
            addCriterion("LOW_PRICE in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<Double> values) {
            addCriterion("LOW_PRICE not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(Double value1, Double value2) {
            addCriterion("LOW_PRICE between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(Double value1, Double value2) {
            addCriterion("LOW_PRICE not between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("VOL is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("VOL is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(Double value) {
            addCriterion("VOL =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(Double value) {
            addCriterion("VOL <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(Double value) {
            addCriterion("VOL >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(Double value) {
            addCriterion("VOL >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(Double value) {
            addCriterion("VOL <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(Double value) {
            addCriterion("VOL <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<Double> values) {
            addCriterion("VOL in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<Double> values) {
            addCriterion("VOL not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(Double value1, Double value2) {
            addCriterion("VOL between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(Double value1, Double value2) {
            addCriterion("VOL not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andChgIsNull() {
            addCriterion("CHG is null");
            return (Criteria) this;
        }

        public Criteria andChgIsNotNull() {
            addCriterion("CHG is not null");
            return (Criteria) this;
        }

        public Criteria andChgEqualTo(Double value) {
            addCriterion("CHG =", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgNotEqualTo(Double value) {
            addCriterion("CHG <>", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgGreaterThan(Double value) {
            addCriterion("CHG >", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgGreaterThanOrEqualTo(Double value) {
            addCriterion("CHG >=", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgLessThan(Double value) {
            addCriterion("CHG <", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgLessThanOrEqualTo(Double value) {
            addCriterion("CHG <=", value, "chg");
            return (Criteria) this;
        }

        public Criteria andChgIn(List<Double> values) {
            addCriterion("CHG in", values, "chg");
            return (Criteria) this;
        }

        public Criteria andChgNotIn(List<Double> values) {
            addCriterion("CHG not in", values, "chg");
            return (Criteria) this;
        }

        public Criteria andChgBetween(Double value1, Double value2) {
            addCriterion("CHG between", value1, value2, "chg");
            return (Criteria) this;
        }

        public Criteria andChgNotBetween(Double value1, Double value2) {
            addCriterion("CHG not between", value1, value2, "chg");
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