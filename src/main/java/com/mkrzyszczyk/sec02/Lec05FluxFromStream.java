package com.mkrzyszczyk.sec02;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec05FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = list.stream();

        Flux<Integer> integerFlux = Flux.fromStream(stream);

        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        // it throws the error: stream has already been operated upon or closed, because stream can be operated only once
        // (this is attribute of streams introduced in Java 8, so it doesn't apply only to Flux from stream but to streams in general)
        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        // working solution:

        integerFlux = Flux.fromStream(() -> list.stream());

        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
