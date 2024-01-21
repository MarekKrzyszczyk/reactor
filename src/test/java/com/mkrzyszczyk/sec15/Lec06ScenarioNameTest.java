package com.mkrzyszczyk.sec15;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

class Lec06ScenarioNameTest {

    @Test
    void test1() {

        Flux<String> flux = Flux.just("a", "b", "c");

        StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("alphabets-test");

        StepVerifier.create(flux, scenarioName)
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void test2() {

        Flux<String> flux = Flux.just("a", "b1", "c");

        StepVerifier.create(flux)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("c")
                .as("c-test")
                .verifyComplete();
    }
}
