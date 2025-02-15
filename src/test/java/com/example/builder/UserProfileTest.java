package com.example.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InvalidObjectException;

class UserProfileTest {
    @Test
    void testBuilder() {
        assertDoesNotThrow(() -> {
            UserProfile userProfile = new UserProfile.Builder()
                .firstName("Sam")
                .phone("6545367865")
                .build();
            
                assertEquals("UserProfile{firstName=\"Sam\", phone=\"6545367865\"}", userProfile.toString());
        });
    }

    @Test
    void testMissingMandatoryFieldsThrowInvalidObjectException() {
        Exception exception = assertThrows(InvalidObjectException.class, () -> {
            new UserProfile.Builder()
                .firstName("Bapu")
                .build();
        });

        String expectedMsg = "Please ensure all the mandatory fields are set.";
        assertEquals(expectedMsg, exception.getMessage());

        exception = assertThrows(InvalidObjectException.class, () -> {
            new UserProfile.Builder()
                .phone("8745348765")
                .build();
        });

        assertEquals(expectedMsg, exception.getMessage());
    }

    @Test
    void testBasicUserProfile() {
        Director director = new Director(new UserProfile.Builder());
        assertDoesNotThrow(() -> {
            UserProfile userProfile = director.buildBasicUserProfile("Gandhi", "6545342312");
            System.out.println("Basic user profile: " + userProfile);
        });
    }

    @Test
    void testFullUserProfile() {
        Director director = new Director(new UserProfile.Builder());
        assertDoesNotThrow(() -> {
            UserProfile userProfile = director.buildFullUserProfile("Sam", "Pitroda", "sam@pitroda.com", "8756437654");
            System.out.println("Full user profile: " + userProfile);
        });
    }
}
