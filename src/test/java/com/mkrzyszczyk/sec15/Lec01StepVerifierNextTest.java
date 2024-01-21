package com.mkrzyszczyk.sec15;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Lec01StepVerifierNextTest {

    @Test
    void test1() {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

    @Test
    void test2() {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        StepVerifier.create(flux)
                .expectNext(1, 2, 3)
                .verifyComplete();
    }
}
