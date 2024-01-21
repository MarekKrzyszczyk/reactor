package com.mkrzyszczyk.sec12;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Lec01Repeat {

    private static final AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) {

        getIntegers()
//                .repeat(2)
                .repeat(() -> counter.get() < 14)
                .subscribe(i -> log.info("Received: {}", i));
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> log.info("Subscribed"))
                .doOnComplete(() -> log.info("Completed"))
                .map(i -> counter.getAndIncrement());
    }
}
