package com.mkrzyszczyk.sec02;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromRange {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .subscribe(Util.onNext());

        //behaviour similar to fori loop
        Flux.range(1, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
