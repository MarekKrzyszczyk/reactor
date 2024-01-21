package com.mkrzyszczyk.sec11;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Lec03Window {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        eventStream()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(Lec03Window::saveEvents)
                .subscribe(strings -> log.info("{}", strings));

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event " + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> events) {
        return events
                .doOnNext(event -> log.info("saving event: {}", event))
                .doOnComplete(() -> log.info("saved this bath -------------------------------"))
                .then(Mono.just(counter.incrementAndGet()));
    }
}
