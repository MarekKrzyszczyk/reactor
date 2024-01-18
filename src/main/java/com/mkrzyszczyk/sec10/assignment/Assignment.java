package com.mkrzyszczyk.sec10.assignment;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Assignment {

    public static void main(String[] args) {

        final int carPrice = 10000;

        Flux.combineLatest(monthStream(), demandStream(), (m, d) -> {
                    return (carPrice - (m * 100)) * d;
                })
                .subscribe(System.out::println);

        Util.sleepSeconds(60);
    }


    private static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(80, 120) / 100.0)
                .startWith(1.0);
    }
}
