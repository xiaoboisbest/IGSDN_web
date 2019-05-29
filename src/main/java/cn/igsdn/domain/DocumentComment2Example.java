package cn.igsdn.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DocumentComment2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentComment2Example() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyIsNull() {
            addCriterion("is_identify is null");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyIsNotNull() {
            addCriterion("is_identify is not null");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyEqualTo(Boolean value) {
            addCriterion("is_identify =", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyNotEqualTo(Boolean value) {
            addCriterion("is_identify <>", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyGreaterThan(Boolean value) {
            addCriterion("is_identify >", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_identify >=", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyLessThan(Boolean value) {
            addCriterion("is_identify <", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_identify <=", value, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyIn(List<Boolean> values) {
            addCriterion("is_identify in", values, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyNotIn(List<Boolean> values) {
            addCriterion("is_identify not in", values, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_identify between", value1, value2, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andIsIdentifyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_identify not between", value1, value2, "isIdentify");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNull() {
            addCriterion("commentator is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorIsNotNull() {
            addCriterion("commentator is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorEqualTo(Integer value) {
            addCriterion("commentator =", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotEqualTo(Integer value) {
            addCriterion("commentator <>", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThan(Integer value) {
            addCriterion("commentator >", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentator >=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThan(Integer value) {
            addCriterion("commentator <", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorLessThanOrEqualTo(Integer value) {
            addCriterion("commentator <=", value, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorIn(List<Integer> values) {
            addCriterion("commentator in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotIn(List<Integer> values) {
            addCriterion("commentator not in", values, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorBetween(Integer value1, Integer value2) {
            addCriterion("commentator between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentatorNotBetween(Integer value1, Integer value2) {
            addCriterion("commentator not between", value1, value2, "commentator");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andIsSecondIsNull() {
            addCriterion("is_second is null");
            return (Criteria) this;
        }

        public Criteria andIsSecondIsNotNull() {
            addCriterion("is_second is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecondEqualTo(Boolean value) {
            addCriterion("is_second =", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotEqualTo(Boolean value) {
            addCriterion("is_second <>", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondGreaterThan(Boolean value) {
            addCriterion("is_second >", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_second >=", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondLessThan(Boolean value) {
            addCriterion("is_second <", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondLessThanOrEqualTo(Boolean value) {
            addCriterion("is_second <=", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondIn(List<Boolean> values) {
            addCriterion("is_second in", values, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotIn(List<Boolean> values) {
            addCriterion("is_second not in", values, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second between", value1, value2, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second not between", value1, value2, "isSecond");
            return (Criteria) this;
        }

        public Criteria andRemarkDateIsNull() {
            addCriterion("remark_date is null");
            return (Criteria) this;
        }

        public Criteria andRemarkDateIsNotNull() {
            addCriterion("remark_date is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkDateEqualTo(Date value) {
            addCriterionForJDBCDate("remark_date =", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("remark_date <>", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("remark_date >", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("remark_date >=", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateLessThan(Date value) {
            addCriterionForJDBCDate("remark_date <", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("remark_date <=", value, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateIn(List<Date> values) {
            addCriterionForJDBCDate("remark_date in", values, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("remark_date not in", values, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("remark_date between", value1, value2, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andRemarkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("remark_date not between", value1, value2, "remarkDate");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNull() {
            addCriterion("document is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIsNotNull() {
            addCriterion("document is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentEqualTo(Integer value) {
            addCriterion("document =", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotEqualTo(Integer value) {
            addCriterion("document <>", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThan(Integer value) {
            addCriterion("document >", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentGreaterThanOrEqualTo(Integer value) {
            addCriterion("document >=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThan(Integer value) {
            addCriterion("document <", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentLessThanOrEqualTo(Integer value) {
            addCriterion("document <=", value, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentIn(List<Integer> values) {
            addCriterion("document in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotIn(List<Integer> values) {
            addCriterion("document not in", values, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentBetween(Integer value1, Integer value2) {
            addCriterion("document between", value1, value2, "document");
            return (Criteria) this;
        }

        public Criteria andDocumentNotBetween(Integer value1, Integer value2) {
            addCriterion("document not between", value1, value2, "document");
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