package com.mkrzyszczyk.sec10;

import com.mkrzyszczyk.courseutil.Util;
import com.mkrzyszczyk.sec10.helper.AmericanFlights;
import com.mkrzyszczyk.sec10.helper.EmiratesFlights;
import com.mkrzyszczyk.sec10.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec04Zip {

    public static void main(String[] args) {
        Flux
                .zip(getBody(), getEngine(), getTires())
                .doOnNext(t -> System.out.println(t.getT3()))
                .subscribe(System.out::println);
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 9)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 6)
                .map(i -> "engine");
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 5)
                .map(i -> "tires");
    }
}
