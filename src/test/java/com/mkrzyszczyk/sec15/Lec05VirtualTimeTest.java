package com.mkrzyszczyk.sec15;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

class Lec05VirtualTimeTest {

    @Test
    void test1() {
        StepVerifier.withVirtualTime(this::timeConsumingFlux)
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("Value 1", "Value 2", "Value 3", "Value 4")
                .verifyComplete();
    }

    @Test
    void test2() {
        StepVerifier.withVirtualTime(this::timeConsumingFlux)
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(4))
                .thenAwait(Duration.ofSeconds(20))
                .expectNext("Value 1", "Value 2", "Value 3", "Value 4")
                .verifyComplete();
    }

    private Flux<String> timeConsumingFlux() {
        return Flux.range(1, 4)
                .delayElements(Duration.ofSeconds(5))
                .map(i -> "Value " + i);
    }
}
