package com.mkrzyszczyk;

import lombok.Getter;

@Getter
public class Car {
    private final long id;
    private final String brand;

    public Car(long id, String brand) {
        this.id = id;
        this.brand = brand;
    }
}
