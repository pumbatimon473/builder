package com.example.builder;

import java.io.InvalidObjectException;

/**
 * Design Pattern: Builder
 * - Type: Creational
 * 
 * Builder design pattern has the following components:
 * 1. Builder: An abstract interface to create objects
 * 2. Concrete Builder: Implements the builder interface and allows us to create immutable objects
 * 3. Director: Allows us to configure how the different versions of the complex object are to be created
 * 4. Product: The complex object that needs to be created
 */
class UserProfile {
    // step 1: make the attrs private
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // step 2: make the CTOR private
    private UserProfile(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // step 3: make a public static inner class: Builder
    public static class Builder {
        // step 4: declare the same set of attrs as there are in the outer class
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        // step 5: make the CTOR public
        public Builder() {
            // initialization logic
        }

        // step 6: provide fluent interfaces for setting the properties of the complex object
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        // step 7: implement build()
        public UserProfile build() throws InvalidObjectException {
            // do necessary validations before creating the object
            if (isValid())
                return new UserProfile(this);
            else
                throw new InvalidObjectException("Please ensure all the mandatory fields are set.");
        }

        private boolean isValid() {
            if (this.firstName == null || this.phone == null || this.firstName.length() < 1 || this.phone.length() < 10 || this.phone.length() > 10)
                return false;
            return true;
        }

    }

    @Override
    public String toString() {
        String objStr = "UserProfile{";
        if (this.firstName != null)
            objStr += "firstName=\"" + this.firstName + "\"";
        if (this.lastName != null)
            objStr += ", lastName=\"" + this.lastName + "\"";
        if (this.email != null)
            objStr += ", email=\"" + this.email + "\"";
        if (this.phone != null)
            objStr += ", phone=\"" + this.phone + "\"";
        objStr += "}";
        return objStr;
    }
}
