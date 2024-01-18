package com.mkrzyszczyk.sec10;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05CombineLast {

    public static void main(String[] args) {
        Flux<String> combineLatest = Flux.combineLatest(getString(), getInteger(), (s, i) -> s + i);

        combineLatest.subscribe(System.out::println);

        Util.sleepSeconds(10);
    }

private static Flux<String> getString() {
    return Flux.just("A", "B", "C", "D")
            .delayElements(Duration.ofSeconds(1));
}

    private static Flux<Integer> getInteger() {
        return Flux.just(1, 2, 3)
                .delayElements(Duration.ofSeconds(3));
    }

}
