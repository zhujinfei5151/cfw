package org.cfw.biz.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
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

        public Criteria andRoleidIsNull() {
            addCriterion("ROLEID is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("ROLEID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Short value) {
            addCriterion("ROLEID =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Short value) {
            addCriterion("ROLEID <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Short value) {
            addCriterion("ROLEID >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Short value) {
            addCriterion("ROLEID >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Short value) {
            addCriterion("ROLEID <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Short value) {
            addCriterion("ROLEID <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Short> values) {
            addCriterion("ROLEID in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Short> values) {
            addCriterion("ROLEID not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Short value1, Short value2) {
            addCriterion("ROLEID between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Short value1, Short value2) {
            addCriterion("ROLEID not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRoleCommentIsNull() {
            addCriterion("ROLECOMMENT is null");
            return (Criteria) this;
        }

        public Criteria andRoleCommentIsNotNull() {
            addCriterion("ROLECOMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCommentEqualTo(String value) {
            addCriterion("ROLECOMMENT =", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentNotEqualTo(String value) {
            addCriterion("ROLECOMMENT <>", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentGreaterThan(String value) {
            addCriterion("ROLECOMMENT >", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ROLECOMMENT >=", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentLessThan(String value) {
            addCriterion("ROLECOMMENT <", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentLessThanOrEqualTo(String value) {
            addCriterion("ROLECOMMENT <=", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentLike(String value) {
            addCriterion("ROLECOMMENT like", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentNotLike(String value) {
            addCriterion("ROLECOMMENT not like", value, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentIn(List<String> values) {
            addCriterion("ROLECOMMENT in", values, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentNotIn(List<String> values) {
            addCriterion("ROLECOMMENT not in", values, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentBetween(String value1, String value2) {
            addCriterion("ROLECOMMENT between", value1, value2, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andRoleCommentNotBetween(String value1, String value2) {
            addCriterion("ROLECOMMENT not between", value1, value2, "rolecomment");
            return (Criteria) this;
        }

        public Criteria andParentroleidIsNull() {
            addCriterion("PARENTROLEID is null");
            return (Criteria) this;
        }

        public Criteria andParentroleidIsNotNull() {
            addCriterion("PARENTROLEID is not null");
            return (Criteria) this;
        }

        public Criteria andParentroleidEqualTo(Short value) {
            addCriterion("PARENTROLEID =", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotEqualTo(Short value) {
            addCriterion("PARENTROLEID <>", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidGreaterThan(Short value) {
            addCriterion("PARENTROLEID >", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidGreaterThanOrEqualTo(Short value) {
            addCriterion("PARENTROLEID >=", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidLessThan(Short value) {
            addCriterion("PARENTROLEID <", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidLessThanOrEqualTo(Short value) {
            addCriterion("PARENTROLEID <=", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidIn(List<Short> values) {
            addCriterion("PARENTROLEID in", values, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotIn(List<Short> values) {
            addCriterion("PARENTROLEID not in", values, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidBetween(Short value1, Short value2) {
            addCriterion("PARENTROLEID between", value1, value2, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotBetween(Short value1, Short value2) {
            addCriterion("PARENTROLEID not between", value1, value2, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateaccountIsNull() {
            addCriterion("CREATEACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreateaccountIsNotNull() {
            addCriterion("CREATEACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreateaccountEqualTo(String value) {
            addCriterion("CREATEACCOUNT =", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountNotEqualTo(String value) {
            addCriterion("CREATEACCOUNT <>", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountGreaterThan(String value) {
            addCriterion("CREATEACCOUNT >", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEACCOUNT >=", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountLessThan(String value) {
            addCriterion("CREATEACCOUNT <", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountLessThanOrEqualTo(String value) {
            addCriterion("CREATEACCOUNT <=", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountLike(String value) {
            addCriterion("CREATEACCOUNT like", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountNotLike(String value) {
            addCriterion("CREATEACCOUNT not like", value, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountIn(List<String> values) {
            addCriterion("CREATEACCOUNT in", values, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountNotIn(List<String> values) {
            addCriterion("CREATEACCOUNT not in", values, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountBetween(String value1, String value2) {
            addCriterion("CREATEACCOUNT between", value1, value2, "createaccount");
            return (Criteria) this;
        }

        public Criteria andCreateaccountNotBetween(String value1, String value2) {
            addCriterion("CREATEACCOUNT not between", value1, value2, "createaccount");
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