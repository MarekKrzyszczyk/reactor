package com.mkrzyszczyk.sec13;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@Slf4j
public class Lec06SinkReplay {

    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().replay().all();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(s -> log.info(s.toString() + " sam"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(s -> log.info(s.toString() + " mike"));
        sink.tryEmitNext("?");


    }
}
