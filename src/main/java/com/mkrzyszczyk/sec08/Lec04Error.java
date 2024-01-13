package com.mkrzyszczyk.sec08;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04Error {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501 && !fluxSink.isCancelled(); i++) {
                        System.out.println("Pushed: " + i);
                        fluxSink.next(i);
                        String name = "Alter name";
                    }
                    fluxSink.complete();
                })
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> Util.sleepMilliseconds(10))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Util.sleepSeconds(60);
    }
}
