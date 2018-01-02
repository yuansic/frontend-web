package com.frontend.web.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TdQuotaWarningCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TdQuotaWarningCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andWarnigIdIsNull() {
            addCriterion("WARNIG_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarnigIdIsNotNull() {
            addCriterion("WARNIG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarnigIdEqualTo(Long value) {
            addCriterion("WARNIG_ID =", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdNotEqualTo(Long value) {
            addCriterion("WARNIG_ID <>", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdGreaterThan(Long value) {
            addCriterion("WARNIG_ID >", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WARNIG_ID >=", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdLessThan(Long value) {
            addCriterion("WARNIG_ID <", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdLessThanOrEqualTo(Long value) {
            addCriterion("WARNIG_ID <=", value, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdIn(List<Long> values) {
            addCriterion("WARNIG_ID in", values, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdNotIn(List<Long> values) {
            addCriterion("WARNIG_ID not in", values, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdBetween(Long value1, Long value2) {
            addCriterion("WARNIG_ID between", value1, value2, "warnigId");
            return (Criteria) this;
        }

        public Criteria andWarnigIdNotBetween(Long value1, Long value2) {
            addCriterion("WARNIG_ID not between", value1, value2, "warnigId");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeIsNull() {
            addCriterion("QUOTA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeIsNotNull() {
            addCriterion("QUOTA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeEqualTo(String value) {
            addCriterion("QUOTA_CODE =", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeNotEqualTo(String value) {
            addCriterion("QUOTA_CODE <>", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeGreaterThan(String value) {
            addCriterion("QUOTA_CODE >", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QUOTA_CODE >=", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeLessThan(String value) {
            addCriterion("QUOTA_CODE <", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeLessThanOrEqualTo(String value) {
            addCriterion("QUOTA_CODE <=", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeLike(String value) {
            addCriterion("QUOTA_CODE like", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeNotLike(String value) {
            addCriterion("QUOTA_CODE not like", value, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeIn(List<String> values) {
            addCriterion("QUOTA_CODE in", values, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeNotIn(List<String> values) {
            addCriterion("QUOTA_CODE not in", values, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeBetween(String value1, String value2) {
            addCriterion("QUOTA_CODE between", value1, value2, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andQuotaCodeNotBetween(String value1, String value2) {
            addCriterion("QUOTA_CODE not between", value1, value2, "quotaCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeIsNull() {
            addCriterion("DIM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDimCodeIsNotNull() {
            addCriterion("DIM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDimCodeEqualTo(String value) {
            addCriterion("DIM_CODE =", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeNotEqualTo(String value) {
            addCriterion("DIM_CODE <>", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeGreaterThan(String value) {
            addCriterion("DIM_CODE >", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DIM_CODE >=", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeLessThan(String value) {
            addCriterion("DIM_CODE <", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeLessThanOrEqualTo(String value) {
            addCriterion("DIM_CODE <=", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeLike(String value) {
            addCriterion("DIM_CODE like", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeNotLike(String value) {
            addCriterion("DIM_CODE not like", value, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeIn(List<String> values) {
            addCriterion("DIM_CODE in", values, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeNotIn(List<String> values) {
            addCriterion("DIM_CODE not in", values, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeBetween(String value1, String value2) {
            addCriterion("DIM_CODE between", value1, value2, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCodeNotBetween(String value1, String value2) {
            addCriterion("DIM_CODE not between", value1, value2, "dimCode");
            return (Criteria) this;
        }

        public Criteria andDimCode2IsNull() {
            addCriterion("DIM_CODE2 is null");
            return (Criteria) this;
        }

        public Criteria andDimCode2IsNotNull() {
            addCriterion("DIM_CODE2 is not null");
            return (Criteria) this;
        }

        public Criteria andDimCode2EqualTo(String value) {
            addCriterion("DIM_CODE2 =", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2NotEqualTo(String value) {
            addCriterion("DIM_CODE2 <>", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2GreaterThan(String value) {
            addCriterion("DIM_CODE2 >", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2GreaterThanOrEqualTo(String value) {
            addCriterion("DIM_CODE2 >=", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2LessThan(String value) {
            addCriterion("DIM_CODE2 <", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2LessThanOrEqualTo(String value) {
            addCriterion("DIM_CODE2 <=", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2Like(String value) {
            addCriterion("DIM_CODE2 like", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2NotLike(String value) {
            addCriterion("DIM_CODE2 not like", value, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2In(List<String> values) {
            addCriterion("DIM_CODE2 in", values, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2NotIn(List<String> values) {
            addCriterion("DIM_CODE2 not in", values, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2Between(String value1, String value2) {
            addCriterion("DIM_CODE2 between", value1, value2, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDimCode2NotBetween(String value1, String value2) {
            addCriterion("DIM_CODE2 not between", value1, value2, "dimCode2");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNull() {
            addCriterion("DIC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNotNull() {
            addCriterion("DIC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDicCodeEqualTo(String value) {
            addCriterion("DIC_CODE =", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotEqualTo(String value) {
            addCriterion("DIC_CODE <>", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThan(String value) {
            addCriterion("DIC_CODE >", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_CODE >=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThan(String value) {
            addCriterion("DIC_CODE <", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThanOrEqualTo(String value) {
            addCriterion("DIC_CODE <=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLike(String value) {
            addCriterion("DIC_CODE like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotLike(String value) {
            addCriterion("DIC_CODE not like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIn(List<String> values) {
            addCriterion("DIC_CODE in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotIn(List<String> values) {
            addCriterion("DIC_CODE not in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeBetween(String value1, String value2) {
            addCriterion("DIC_CODE between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotBetween(String value1, String value2) {
            addCriterion("DIC_CODE not between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andWarningMinIsNull() {
            addCriterion("WARNING_MIN is null");
            return (Criteria) this;
        }

        public Criteria andWarningMinIsNotNull() {
            addCriterion("WARNING_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andWarningMinEqualTo(String value) {
            addCriterion("WARNING_MIN =", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinNotEqualTo(String value) {
            addCriterion("WARNING_MIN <>", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinGreaterThan(String value) {
            addCriterion("WARNING_MIN >", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinGreaterThanOrEqualTo(String value) {
            addCriterion("WARNING_MIN >=", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinLessThan(String value) {
            addCriterion("WARNING_MIN <", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinLessThanOrEqualTo(String value) {
            addCriterion("WARNING_MIN <=", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinLike(String value) {
            addCriterion("WARNING_MIN like", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinNotLike(String value) {
            addCriterion("WARNING_MIN not like", value, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinIn(List<String> values) {
            addCriterion("WARNING_MIN in", values, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinNotIn(List<String> values) {
            addCriterion("WARNING_MIN not in", values, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinBetween(String value1, String value2) {
            addCriterion("WARNING_MIN between", value1, value2, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMinNotBetween(String value1, String value2) {
            addCriterion("WARNING_MIN not between", value1, value2, "warningMin");
            return (Criteria) this;
        }

        public Criteria andWarningMaxIsNull() {
            addCriterion("WARNING_MAX is null");
            return (Criteria) this;
        }

        public Criteria andWarningMaxIsNotNull() {
            addCriterion("WARNING_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andWarningMaxEqualTo(String value) {
            addCriterion("WARNING_MAX =", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxNotEqualTo(String value) {
            addCriterion("WARNING_MAX <>", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxGreaterThan(String value) {
            addCriterion("WARNING_MAX >", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxGreaterThanOrEqualTo(String value) {
            addCriterion("WARNING_MAX >=", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxLessThan(String value) {
            addCriterion("WARNING_MAX <", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxLessThanOrEqualTo(String value) {
            addCriterion("WARNING_MAX <=", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxLike(String value) {
            addCriterion("WARNING_MAX like", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxNotLike(String value) {
            addCriterion("WARNING_MAX not like", value, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxIn(List<String> values) {
            addCriterion("WARNING_MAX in", values, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxNotIn(List<String> values) {
            addCriterion("WARNING_MAX not in", values, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxBetween(String value1, String value2) {
            addCriterion("WARNING_MAX between", value1, value2, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarningMaxNotBetween(String value1, String value2) {
            addCriterion("WARNING_MAX not between", value1, value2, "warningMax");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeIsNull() {
            addCriterion("WARNIG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeIsNotNull() {
            addCriterion("WARNIG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeEqualTo(String value) {
            addCriterion("WARNIG_TYPE =", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeNotEqualTo(String value) {
            addCriterion("WARNIG_TYPE <>", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeGreaterThan(String value) {
            addCriterion("WARNIG_TYPE >", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WARNIG_TYPE >=", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeLessThan(String value) {
            addCriterion("WARNIG_TYPE <", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeLessThanOrEqualTo(String value) {
            addCriterion("WARNIG_TYPE <=", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeLike(String value) {
            addCriterion("WARNIG_TYPE like", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeNotLike(String value) {
            addCriterion("WARNIG_TYPE not like", value, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeIn(List<String> values) {
            addCriterion("WARNIG_TYPE in", values, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeNotIn(List<String> values) {
            addCriterion("WARNIG_TYPE not in", values, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeBetween(String value1, String value2) {
            addCriterion("WARNIG_TYPE between", value1, value2, "warnigType");
            return (Criteria) this;
        }

        public Criteria andWarnigTypeNotBetween(String value1, String value2) {
            addCriterion("WARNIG_TYPE not between", value1, value2, "warnigType");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIsNull() {
            addCriterion("UPDATE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIsNotNull() {
            addCriterion("UPDATE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdEqualTo(Long value) {
            addCriterion("UPDATE_STAFF_ID =", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotEqualTo(Long value) {
            addCriterion("UPDATE_STAFF_ID <>", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdGreaterThan(Long value) {
            addCriterion("UPDATE_STAFF_ID >", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATE_STAFF_ID >=", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdLessThan(Long value) {
            addCriterion("UPDATE_STAFF_ID <", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("UPDATE_STAFF_ID <=", value, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdIn(List<Long> values) {
            addCriterion("UPDATE_STAFF_ID in", values, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotIn(List<Long> values) {
            addCriterion("UPDATE_STAFF_ID not in", values, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdBetween(Long value1, Long value2) {
            addCriterion("UPDATE_STAFF_ID between", value1, value2, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("UPDATE_STAFF_ID not between", value1, value2, "updateStaffId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNull() {
            addCriterion("CREATE_STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIsNotNull() {
            addCriterion("CREATE_STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdEqualTo(Long value) {
            addCriterion("CREATE_STAFF_ID =", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotEqualTo(Long value) {
            addCriterion("CREATE_STAFF_ID <>", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThan(Long value) {
            addCriterion("CREATE_STAFF_ID >", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_STAFF_ID >=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThan(Long value) {
            addCriterion("CREATE_STAFF_ID <", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_STAFF_ID <=", value, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdIn(List<Long> values) {
            addCriterion("CREATE_STAFF_ID in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotIn(List<Long> values) {
            addCriterion("CREATE_STAFF_ID not in", values, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdBetween(Long value1, Long value2) {
            addCriterion("CREATE_STAFF_ID between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_STAFF_ID not between", value1, value2, "createStaffId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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