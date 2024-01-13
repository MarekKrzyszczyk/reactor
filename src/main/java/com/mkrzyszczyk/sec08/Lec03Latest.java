package com.mkrzyszczyk.sec08;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03Latest {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> Util.sleepMilliseconds(10))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Util.sleepSeconds(60);
    }
}
