package com.mkrzyszczyk.sec13;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.time.Duration;

@Slf4j
public class Lec05SinkMulticastDirectAll {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

//        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(s -> log.info(s.toString() + " sam"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(s -> log.info(s.toString() + " mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSeconds(10);
    }
}
