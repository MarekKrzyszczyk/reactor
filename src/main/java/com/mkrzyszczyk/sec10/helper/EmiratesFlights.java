package com.mkrzyszczyk.sec10.helper;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class EmiratesFlights {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates " + Util.faker().random().nextInt(100, 999))
                .filter(s -> Util.faker().random().nextBoolean());
    }
}
