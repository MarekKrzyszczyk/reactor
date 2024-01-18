package com.mkrzyszczyk.sec11;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Lec02OverlapAndDrop {

    public static void main(String[] args) {

        eventStream()
                .buffer(3, 1)
                .subscribe(strings -> log.info("{}", strings));

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i);
    }
}
