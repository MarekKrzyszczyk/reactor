package com.mkrzyszczyk.sec02;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {

        //every 1 second, e.g. set to 5 to invoke every 5 seconds. We can use also minutes, days etc.
        Flux.interval(Duration.ofSeconds(1))
                .map(aLong -> Util.faker().name().fullName())
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
