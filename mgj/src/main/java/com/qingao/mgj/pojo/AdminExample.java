package com.qingao.mgj.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdidIsNull() {
            addCriterion("adid is null");
            return (Criteria) this;
        }

        public Criteria andAdidIsNotNull() {
            addCriterion("adid is not null");
            return (Criteria) this;
        }

        public Criteria andAdidEqualTo(Integer value) {
            addCriterion("adid =", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotEqualTo(Integer value) {
            addCriterion("adid <>", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThan(Integer value) {
            addCriterion("adid >", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adid >=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThan(Integer value) {
            addCriterion("adid <", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThanOrEqualTo(Integer value) {
            addCriterion("adid <=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidIn(List<Integer> values) {
            addCriterion("adid in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotIn(List<Integer> values) {
            addCriterion("adid not in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidBetween(Integer value1, Integer value2) {
            addCriterion("adid between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotBetween(Integer value1, Integer value2) {
            addCriterion("adid not between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andAdnameIsNull() {
            addCriterion("adname is null");
            return (Criteria) this;
        }

        public Criteria andAdnameIsNotNull() {
            addCriterion("adname is not null");
            return (Criteria) this;
        }

        public Criteria andAdnameEqualTo(String value) {
            addCriterion("adname =", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotEqualTo(String value) {
            addCriterion("adname <>", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThan(String value) {
            addCriterion("adname >", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThanOrEqualTo(String value) {
            addCriterion("adname >=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThan(String value) {
            addCriterion("adname <", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThanOrEqualTo(String value) {
            addCriterion("adname <=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLike(String value) {
            addCriterion("adname like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotLike(String value) {
            addCriterion("adname not like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameIn(List<String> values) {
            addCriterion("adname in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotIn(List<String> values) {
            addCriterion("adname not in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameBetween(String value1, String value2) {
            addCriterion("adname between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotBetween(String value1, String value2) {
            addCriterion("adname not between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andAdpasswordIsNull() {
            addCriterion("adpassword is null");
            return (Criteria) this;
        }

        public Criteria andAdpasswordIsNotNull() {
            addCriterion("adpassword is not null");
            return (Criteria) this;
        }

        public Criteria andAdpasswordEqualTo(String value) {
            addCriterion("adpassword =", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordNotEqualTo(String value) {
            addCriterion("adpassword <>", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordGreaterThan(String value) {
            addCriterion("adpassword >", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("adpassword >=", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordLessThan(String value) {
            addCriterion("adpassword <", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordLessThanOrEqualTo(String value) {
            addCriterion("adpassword <=", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordLike(String value) {
            addCriterion("adpassword like", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordNotLike(String value) {
            addCriterion("adpassword not like", value, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordIn(List<String> values) {
            addCriterion("adpassword in", values, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordNotIn(List<String> values) {
            addCriterion("adpassword not in", values, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordBetween(String value1, String value2) {
            addCriterion("adpassword between", value1, value2, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdpasswordNotBetween(String value1, String value2) {
            addCriterion("adpassword not between", value1, value2, "adpassword");
            return (Criteria) this;
        }

        public Criteria andAdsaltIsNull() {
            addCriterion("adsalt is null");
            return (Criteria) this;
        }

        public Criteria andAdsaltIsNotNull() {
            addCriterion("adsalt is not null");
            return (Criteria) this;
        }

        public Criteria andAdsaltEqualTo(String value) {
            addCriterion("adsalt =", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltNotEqualTo(String value) {
            addCriterion("adsalt <>", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltGreaterThan(String value) {
            addCriterion("adsalt >", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltGreaterThanOrEqualTo(String value) {
            addCriterion("adsalt >=", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltLessThan(String value) {
            addCriterion("adsalt <", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltLessThanOrEqualTo(String value) {
            addCriterion("adsalt <=", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltLike(String value) {
            addCriterion("adsalt like", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltNotLike(String value) {
            addCriterion("adsalt not like", value, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltIn(List<String> values) {
            addCriterion("adsalt in", values, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltNotIn(List<String> values) {
            addCriterion("adsalt not in", values, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltBetween(String value1, String value2) {
            addCriterion("adsalt between", value1, value2, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdsaltNotBetween(String value1, String value2) {
            addCriterion("adsalt not between", value1, value2, "adsalt");
            return (Criteria) this;
        }

        public Criteria andAdstatusIsNull() {
            addCriterion("adstatus is null");
            return (Criteria) this;
        }

        public Criteria andAdstatusIsNotNull() {
            addCriterion("adstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAdstatusEqualTo(Integer value) {
            addCriterion("adstatus =", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusNotEqualTo(Integer value) {
            addCriterion("adstatus <>", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusGreaterThan(Integer value) {
            addCriterion("adstatus >", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("adstatus >=", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusLessThan(Integer value) {
            addCriterion("adstatus <", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusLessThanOrEqualTo(Integer value) {
            addCriterion("adstatus <=", value, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusIn(List<Integer> values) {
            addCriterion("adstatus in", values, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusNotIn(List<Integer> values) {
            addCriterion("adstatus not in", values, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusBetween(Integer value1, Integer value2) {
            addCriterion("adstatus between", value1, value2, "adstatus");
            return (Criteria) this;
        }

        public Criteria andAdstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("adstatus not between", value1, value2, "adstatus");
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