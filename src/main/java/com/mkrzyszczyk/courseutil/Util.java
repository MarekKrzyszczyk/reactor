package com.mkrzyszczyk.courseutil;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> log.info("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> log.info("ERROR: " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> log.info("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        sleepMilliseconds(seconds * 1000);
    }

    public static void sleepMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted", e);
        }
    }

    /**
     * Calculates the sum of all numbers in the given list.
     *
     * @param numbers The list of numbers.
     * @return The sum of all numbers.
     * @throws IllegalArgumentException If the input list is null.
     */
    public static int sumNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    
}
