package com.mkrzyszczyk.sec12;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.sql.SQLData;
import java.time.Duration;

@Slf4j
public class Lec03RetryAdvanced {

    public static void main(String[] args) {

        orderService(Util.faker().business().creditCardNumber())
                .retryWhen(Retry.from(
                        flux -> flux
                                .doOnNext(i -> {
                                    log.info(i.totalRetries() + " retries");
                                    log.info(i.failure() + " failure");
                                })
                                .handle(
                                        (retrySignal, sink) -> {
                                            if (retrySignal.failure().getMessage().equals("500")) {
                                                sink.next(1);
                                            } else {
                                                sink.error(retrySignal.failure());
                                            }
                                        })
                                .delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(i -> log.info("Received: {}", i));

        Util.sleepSeconds(60);
    }

    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Util.faker().idNumber().valid();
        });
    }

    private static void processPayment(String ccNumber) {
        int random = Util.faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }

}
