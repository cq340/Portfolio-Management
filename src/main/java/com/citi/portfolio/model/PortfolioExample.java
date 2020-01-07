package com.citi.portfolio.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class PortfolioExample {
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

    public PortfolioExample() {
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

        public Criteria andPortDateIsNull() {
            addCriterion("PORT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPortDateIsNotNull() {
            addCriterion("PORT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPortDateEqualTo(Date value) {
            addCriterionForJDBCDate("PORT_DATE =", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PORT_DATE <>", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateGreaterThan(Date value) {
            addCriterionForJDBCDate("PORT_DATE >", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PORT_DATE >=", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateLessThan(Date value) {
            addCriterionForJDBCDate("PORT_DATE <", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PORT_DATE <=", value, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateIn(List<Date> values) {
            addCriterionForJDBCDate("PORT_DATE in", values, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PORT_DATE not in", values, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PORT_DATE between", value1, value2, "portDate");
            return (Criteria) this;
        }

        public Criteria andPortDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PORT_DATE not between", value1, value2, "portDate");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("MANAGER_ID is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("MANAGER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("MANAGER_ID =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("MANAGER_ID <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("MANAGER_ID >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("MANAGER_ID <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("MANAGER_ID in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("MANAGER_ID not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID not between", value1, value2, "managerId");
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