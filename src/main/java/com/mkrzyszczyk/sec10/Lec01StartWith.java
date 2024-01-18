package com.mkrzyszczyk.sec10;

import com.mkrzyszczyk.sec10.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(s -> System.out.println("sam " + s));

        generator.generateNames()
                .take(2)
                .subscribe(s -> System.out.println("mike " + s));

        generator.generateNames()
                .take(3)
                .subscribe(s -> System.out.println("jake " + s));
    }
}
