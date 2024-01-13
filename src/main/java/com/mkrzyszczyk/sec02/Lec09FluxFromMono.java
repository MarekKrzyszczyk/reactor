package com.mkrzyszczyk.sec02;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());

        doSomething(flux);

        Flux.range(1, 10)
                .filter(integer -> integer > 3)
                .next() // convert flux to mono
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
