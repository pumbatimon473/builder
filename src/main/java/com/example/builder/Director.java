package com.example.builder;

import java.io.InvalidObjectException;

/**
 * Defining 'Director' for the Builder design pattern - Optional
 * - It's more of a convenience class that allows us to create specific versions of the complex object
 * 
 * Analogy: Building different configurations of a car
 */
public class Director {
    private UserProfile.Builder builder;

    // CTOR - accepts a builder instance
    public Director(UserProfile.Builder builder) {
        this.builder = builder;
    }

    // define methods to build different user profiles
    public UserProfile buildBasicUserProfile(String firstName, String phone) throws InvalidObjectException {
        return this.builder.firstName(firstName).phone(phone).build();
    }

    public UserProfile buildFullUserProfile(String firstName, String lastName, String email, String phone) throws InvalidObjectException {
        return this.builder
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .phone(phone)
            .build();
    }
}
