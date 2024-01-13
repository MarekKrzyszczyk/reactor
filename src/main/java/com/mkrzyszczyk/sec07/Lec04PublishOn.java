package com.mkrzyszczyk.sec07;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(o -> printThreadName("next " + o));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> printThreadName("next " + o))
                .subscribe(o -> printThreadName("sub " + o));


        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
