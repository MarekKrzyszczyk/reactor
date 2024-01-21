package com.mkrzyszczyk.sec13;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Slf4j
public class Lec01SinkOne {

    public static void main(String[] args) {

        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();

        mono.subscribe(s -> log.info(s.toString() + " sam"));
        mono.subscribe(s -> log.info(s.toString() + " mike"));

//        sink.tryEmitValue("hi");
//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("err"));

//        sink.emitValue("hi", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });
//
//        sink.emitValue("hello", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return true;
//        });

        sink.tryEmitValue("hello");
    }
}
