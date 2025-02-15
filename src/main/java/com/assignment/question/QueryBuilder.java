package com.assignment.question;

@WithBuilder
public class QueryBuilder {
    // step 1: declare the same set of attrs as there are in the Query class
    private String select;
    private String from;
    private String where;
    private String join;
    private String orderBy;
    private String groupBy;

    // step 2: make the CTOR private
    private QueryBuilder(Builder builder) {
        // object initialization logic
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.join = builder.join;
        this.groupBy = builder.groupBy;
        this.orderBy = builder.orderBy;
    }

    // step 3: declare a static inner class 'Builder'
    public static class Builder {
        private String select;
        private String from;
        private String where;
        private String join;
        private String orderBy;
        private String groupBy;

        // step 4: make fluent interfaces to set the attrs
        public Builder select(String select) {
            this.select = select;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder where(String where) {
            this.where = where;
            return this;
        }

        public Builder join(String join) {
            this.join = join;
            return this;
        }

        public Builder groupBy(String groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        // step 5: define build()
        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }
}