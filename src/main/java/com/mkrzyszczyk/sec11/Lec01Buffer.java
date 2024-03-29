package com.mkrzyszczyk.sec11;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {

    public static void main(String[] args) {

        eventStream()
//                .buffer(5)
//                .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(System.out::println);

        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> "event " + i);
    }
}
