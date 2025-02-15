package com.assignment.question;

@WithBuilder
public class DatabaseConfigurationBuilder {
    // step 1: define the same set of attrs as there are in the DatabaseConfiguration class
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    // step 2: define a private CTOR
    private DatabaseConfigurationBuilder(Builder builder) {
        // object initialization logic
        this.databaseUrl = builder.databaseUrl;
        this.username = builder.username;
        this.password = builder.password;
        this.maxConnections = builder.maxConnections;
        this.enableCache = builder.enableCache;
        this.isReadOnly = builder.isReadOnly;
    }

    // step 3: define a static inner class Builder
    public static class Builder {
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;

        // step 3: define fluent interfaces for setting the attrs
        public Builder databaseUrl(String databaseUrl) {
            this.databaseUrl = databaseUrl;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder enableCache(boolean enableCache) {
            this.enableCache = enableCache;
            return this;
        }

        public Builder isReadOnly(boolean isReadOnly) {
            this.isReadOnly = isReadOnly;
            return this;
        }

        // step 4: define build()
        public DatabaseConfigurationBuilder build() {
            return new DatabaseConfigurationBuilder(this);
        }

    }
}