package com.mkrzyszczyk.sec02;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        Flux<Integer> just = Flux.just(1, 2, 3);

        just.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
