package com.mkrzyszczyk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {
    /**
     * Method under test: {@link Car#Car(long, String)}
     */
    @Test
    void testNewCar() {
        // Arrange and Act
        Car actualCar = new Car(1L, "Brand");

        // Assert
        assertEquals("Brand", actualCar.getBrand());
        assertEquals(1L, actualCar.getId());
    }
}
