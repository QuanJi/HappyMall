package pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ColumnmanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ColumnmanageExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentColumnIsNull() {
            addCriterion("parent_column is null");
            return (Criteria) this;
        }

        public Criteria andParentColumnIsNotNull() {
            addCriterion("parent_column is not null");
            return (Criteria) this;
        }

        public Criteria andParentColumnEqualTo(String value) {
            addCriterion("parent_column =", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnNotEqualTo(String value) {
            addCriterion("parent_column <>", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnGreaterThan(String value) {
            addCriterion("parent_column >", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnGreaterThanOrEqualTo(String value) {
            addCriterion("parent_column >=", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnLessThan(String value) {
            addCriterion("parent_column <", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnLessThanOrEqualTo(String value) {
            addCriterion("parent_column <=", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnLike(String value) {
            addCriterion("parent_column like", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnNotLike(String value) {
            addCriterion("parent_column not like", value, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnIn(List<String> values) {
            addCriterion("parent_column in", values, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnNotIn(List<String> values) {
            addCriterion("parent_column not in", values, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnBetween(String value1, String value2) {
            addCriterion("parent_column between", value1, value2, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andParentColumnNotBetween(String value1, String value2) {
            addCriterion("parent_column not between", value1, value2, "parentColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnIsNull() {
            addCriterion("son_column is null");
            return (Criteria) this;
        }

        public Criteria andSonColumnIsNotNull() {
            addCriterion("son_column is not null");
            return (Criteria) this;
        }

        public Criteria andSonColumnEqualTo(String value) {
            addCriterion("son_column =", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnNotEqualTo(String value) {
            addCriterion("son_column <>", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnGreaterThan(String value) {
            addCriterion("son_column >", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnGreaterThanOrEqualTo(String value) {
            addCriterion("son_column >=", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnLessThan(String value) {
            addCriterion("son_column <", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnLessThanOrEqualTo(String value) {
            addCriterion("son_column <=", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnLike(String value) {
            addCriterion("son_column like", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnNotLike(String value) {
            addCriterion("son_column not like", value, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnIn(List<String> values) {
            addCriterion("son_column in", values, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnNotIn(List<String> values) {
            addCriterion("son_column not in", values, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnBetween(String value1, String value2) {
            addCriterion("son_column between", value1, value2, "sonColumn");
            return (Criteria) this;
        }

        public Criteria andSonColumnNotBetween(String value1, String value2) {
            addCriterion("son_column not between", value1, value2, "sonColumn");
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