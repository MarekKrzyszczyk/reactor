package com.mkrzyszczyk.sec02.assignment;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    public static Flux<Integer> getStockPrice() {
        AtomicInteger startValue = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(2))
                .map(price -> startValue.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    }
}
