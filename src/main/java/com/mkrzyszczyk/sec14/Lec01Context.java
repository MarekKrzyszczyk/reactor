package com.mkrzyszczyk.sec14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@Slf4j
public class Lec01Context {

    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(Context.of("user", "jake"))
                .subscribe(log::info);
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
