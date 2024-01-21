package com.mkrzyszczyk.sec15;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

class Lec07ContextTest {

    @Test
    void test1() {
        StepVerifier.create(getWelcomeMessage())
                    .verifyError(RuntimeException.class);
    }

    @Test
    void test2() {
        StepVerifierOptions stepVerifierOptions = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));
        StepVerifier.create(getWelcomeMessage(), stepVerifierOptions)
                .expectNext("Welcome sam")
                .verifyComplete();
    }

    private Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
