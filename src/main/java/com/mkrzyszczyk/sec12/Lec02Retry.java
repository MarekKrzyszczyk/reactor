package com.mkrzyszczyk.sec12;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Lec02Retry {

    public static void main(String[] args) {

        getIntegers()
                .retry(2)
                .subscribe(i -> log.info("Received: {}", i));
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> log.info("Subscribed"))
                .doOnComplete(() -> log.info("Completed"))
                .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
                .doOnError(e -> log.error("Error", e));
    }
}
