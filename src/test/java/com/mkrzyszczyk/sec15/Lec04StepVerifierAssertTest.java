package com.mkrzyszczyk.sec15;

import com.mkrzyszczyk.sec11.assignment.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

class Lec04StepVerifierAssertTest {

    @Test
    void test1() {
        Mono<BookOrder> mono = Mono.fromSupplier(BookOrder::new);

        StepVerifier.create(mono)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .verifyComplete();
    }

    @Test
    void test2() {
        Mono<BookOrder> mono = Mono.fromSupplier(BookOrder::new).delayElement(Duration.ofSeconds(3));

        StepVerifier.create(mono)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));
    }
}
