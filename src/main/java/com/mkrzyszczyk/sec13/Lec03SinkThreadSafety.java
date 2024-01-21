package com.mkrzyszczyk.sec13;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Lec03SinkThreadSafety {

    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        List<Object> list = new ArrayList<>();
        flux.subscribe(list::add);

//        for (int i = 0; i < 1000; i++) {
//            final int j = i;
//            CompletableFuture.runAsync(() -> {
//                sink.tryEmitNext(j);
//            });
//        }

        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() + " " + j);
                sink.emitNext(j, (s, e) -> true);
            });
        }

        Util.sleepSeconds(3);
        System.out.println(list.size());
    }
}
