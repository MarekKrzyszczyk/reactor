package com.mkrzyszczyk.sec04;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(20,5);
    }
}
