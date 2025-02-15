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
}
