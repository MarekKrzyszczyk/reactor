package com.mkrzyszczyk.sec07;

import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(o -> printThreadName("next " + o));

        flux.subscribe(o -> printThreadName("sub " + o));

    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
