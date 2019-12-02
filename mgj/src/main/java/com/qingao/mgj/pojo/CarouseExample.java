package com.qingao.mgj.pojo;

import java.util.ArrayList;
import java.util.List;

public class CarouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarouseExample() {
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

        public Criteria andClidIsNull() {
            addCriterion("clid is null");
            return (Criteria) this;
        }

        public Criteria andClidIsNotNull() {
            addCriterion("clid is not null");
            return (Criteria) this;
        }

        public Criteria andClidEqualTo(Integer value) {
            addCriterion("clid =", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotEqualTo(Integer value) {
            addCriterion("clid <>", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidGreaterThan(Integer value) {
            addCriterion("clid >", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidGreaterThanOrEqualTo(Integer value) {
            addCriterion("clid >=", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidLessThan(Integer value) {
            addCriterion("clid <", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidLessThanOrEqualTo(Integer value) {
            addCriterion("clid <=", value, "clid");
            return (Criteria) this;
        }

        public Criteria andClidIn(List<Integer> values) {
            addCriterion("clid in", values, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotIn(List<Integer> values) {
            addCriterion("clid not in", values, "clid");
            return (Criteria) this;
        }

        public Criteria andClidBetween(Integer value1, Integer value2) {
            addCriterion("clid between", value1, value2, "clid");
            return (Criteria) this;
        }

        public Criteria andClidNotBetween(Integer value1, Integer value2) {
            addCriterion("clid not between", value1, value2, "clid");
            return (Criteria) this;
        }

        public Criteria andClnameIsNull() {
            addCriterion("clname is null");
            return (Criteria) this;
        }

        public Criteria andClnameIsNotNull() {
            addCriterion("clname is not null");
            return (Criteria) this;
        }

        public Criteria andClnameEqualTo(String value) {
            addCriterion("clname =", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotEqualTo(String value) {
            addCriterion("clname <>", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThan(String value) {
            addCriterion("clname >", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameGreaterThanOrEqualTo(String value) {
            addCriterion("clname >=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThan(String value) {
            addCriterion("clname <", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLessThanOrEqualTo(String value) {
            addCriterion("clname <=", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameLike(String value) {
            addCriterion("clname like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotLike(String value) {
            addCriterion("clname not like", value, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameIn(List<String> values) {
            addCriterion("clname in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotIn(List<String> values) {
            addCriterion("clname not in", values, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameBetween(String value1, String value2) {
            addCriterion("clname between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClnameNotBetween(String value1, String value2) {
            addCriterion("clname not between", value1, value2, "clname");
            return (Criteria) this;
        }

        public Criteria andClimgurlIsNull() {
            addCriterion("climgurl is null");
            return (Criteria) this;
        }

        public Criteria andClimgurlIsNotNull() {
            addCriterion("climgurl is not null");
            return (Criteria) this;
        }

        public Criteria andClimgurlEqualTo(String value) {
            addCriterion("climgurl =", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlNotEqualTo(String value) {
            addCriterion("climgurl <>", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlGreaterThan(String value) {
            addCriterion("climgurl >", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("climgurl >=", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlLessThan(String value) {
            addCriterion("climgurl <", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlLessThanOrEqualTo(String value) {
            addCriterion("climgurl <=", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlLike(String value) {
            addCriterion("climgurl like", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlNotLike(String value) {
            addCriterion("climgurl not like", value, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlIn(List<String> values) {
            addCriterion("climgurl in", values, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlNotIn(List<String> values) {
            addCriterion("climgurl not in", values, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlBetween(String value1, String value2) {
            addCriterion("climgurl between", value1, value2, "climgurl");
            return (Criteria) this;
        }

        public Criteria andClimgurlNotBetween(String value1, String value2) {
            addCriterion("climgurl not between", value1, value2, "climgurl");
            return (Criteria) this;
        }

        public Criteria andCltimeIsNull() {
            addCriterion("cltime is null");
            return (Criteria) this;
        }

        public Criteria andCltimeIsNotNull() {
            addCriterion("cltime is not null");
            return (Criteria) this;
        }

        public Criteria andCltimeEqualTo(Integer value) {
            addCriterion("cltime =", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeNotEqualTo(Integer value) {
            addCriterion("cltime <>", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeGreaterThan(Integer value) {
            addCriterion("cltime >", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cltime >=", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeLessThan(Integer value) {
            addCriterion("cltime <", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeLessThanOrEqualTo(Integer value) {
            addCriterion("cltime <=", value, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeIn(List<Integer> values) {
            addCriterion("cltime in", values, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeNotIn(List<Integer> values) {
            addCriterion("cltime not in", values, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeBetween(Integer value1, Integer value2) {
            addCriterion("cltime between", value1, value2, "cltime");
            return (Criteria) this;
        }

        public Criteria andCltimeNotBetween(Integer value1, Integer value2) {
            addCriterion("cltime not between", value1, value2, "cltime");
            return (Criteria) this;
        }

        public Criteria andClpriceIsNull() {
            addCriterion("clprice is null");
            return (Criteria) this;
        }

        public Criteria andClpriceIsNotNull() {
            addCriterion("clprice is not null");
            return (Criteria) this;
        }

        public Criteria andClpriceEqualTo(Integer value) {
            addCriterion("clprice =", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceNotEqualTo(Integer value) {
            addCriterion("clprice <>", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceGreaterThan(Integer value) {
            addCriterion("clprice >", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("clprice >=", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceLessThan(Integer value) {
            addCriterion("clprice <", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceLessThanOrEqualTo(Integer value) {
            addCriterion("clprice <=", value, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceIn(List<Integer> values) {
            addCriterion("clprice in", values, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceNotIn(List<Integer> values) {
            addCriterion("clprice not in", values, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceBetween(Integer value1, Integer value2) {
            addCriterion("clprice between", value1, value2, "clprice");
            return (Criteria) this;
        }

        public Criteria andClpriceNotBetween(Integer value1, Integer value2) {
            addCriterion("clprice not between", value1, value2, "clprice");
            return (Criteria) this;
        }

        public Criteria andCltypeIsNull() {
            addCriterion("cltype is null");
            return (Criteria) this;
        }

        public Criteria andCltypeIsNotNull() {
            addCriterion("cltype is not null");
            return (Criteria) this;
        }

        public Criteria andCltypeEqualTo(Integer value) {
            addCriterion("cltype =", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeNotEqualTo(Integer value) {
            addCriterion("cltype <>", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeGreaterThan(Integer value) {
            addCriterion("cltype >", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cltype >=", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeLessThan(Integer value) {
            addCriterion("cltype <", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeLessThanOrEqualTo(Integer value) {
            addCriterion("cltype <=", value, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeIn(List<Integer> values) {
            addCriterion("cltype in", values, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeNotIn(List<Integer> values) {
            addCriterion("cltype not in", values, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeBetween(Integer value1, Integer value2) {
            addCriterion("cltype between", value1, value2, "cltype");
            return (Criteria) this;
        }

        public Criteria andCltypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cltype not between", value1, value2, "cltype");
            return (Criteria) this;
        }

        public Criteria andStidIsNull() {
            addCriterion("stid is null");
            return (Criteria) this;
        }

        public Criteria andStidIsNotNull() {
            addCriterion("stid is not null");
            return (Criteria) this;
        }

        public Criteria andStidEqualTo(Integer value) {
            addCriterion("stid =", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotEqualTo(Integer value) {
            addCriterion("stid <>", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThan(Integer value) {
            addCriterion("stid >", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stid >=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThan(Integer value) {
            addCriterion("stid <", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidLessThanOrEqualTo(Integer value) {
            addCriterion("stid <=", value, "stid");
            return (Criteria) this;
        }

        public Criteria andStidIn(List<Integer> values) {
            addCriterion("stid in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotIn(List<Integer> values) {
            addCriterion("stid not in", values, "stid");
            return (Criteria) this;
        }

        public Criteria andStidBetween(Integer value1, Integer value2) {
            addCriterion("stid between", value1, value2, "stid");
            return (Criteria) this;
        }

        public Criteria andStidNotBetween(Integer value1, Integer value2) {
            addCriterion("stid not between", value1, value2, "stid");
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