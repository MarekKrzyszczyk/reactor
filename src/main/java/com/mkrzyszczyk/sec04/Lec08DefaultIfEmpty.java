package com.mkrzyszczyk.sec04;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10);
    }
}
