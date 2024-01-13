package com.mkrzyszczyk.sec05;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06Quiz {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });
        Flux<Integer> cache = flux.filter(i -> i > 1).cache(1);

        cache.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
        cache.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
