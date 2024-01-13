package com.mkrzyszczyk.sec01;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(integer -> integer / 2);

        mono.subscribe();

        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
