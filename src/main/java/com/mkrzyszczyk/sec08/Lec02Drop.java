package com.mkrzyszczyk.sec08;

import com.mkrzyszczyk.courseutil.Util;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec02Drop {

    public static void main(String[] args) {
        BlockHound.install();

        String a = Mono.just("block").cache().block();

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> Util.sleepMilliseconds(10))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Util.sleepSeconds(60);
    }
}
