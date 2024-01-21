package com.mkrzyszczyk.sec13;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
public class Lec04SinkMulticast {

    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(s -> log.info(s.toString() + " sam"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(s -> log.info(s.toString() + " mike"));
        sink.tryEmitNext("?");
    }
}
