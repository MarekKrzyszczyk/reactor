package com.mkrzyszczyk.sec11;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Lec04Group {


    public static void main(String[] args) {

        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2)
                .subscribe(g -> process(g, g.key()));


        Util.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key) {
        log.info("Called");
        flux.subscribe(i -> log.info("key: {}, value: {}", key, i));
    }
}
