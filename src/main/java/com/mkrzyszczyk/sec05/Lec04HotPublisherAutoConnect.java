package com.mkrzyszczyk.sec05;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublisherAutoConnect {

    public static void main(String[] args) {
        //share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(Lec04HotPublisherAutoConnect::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);

        movieStream
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        Util.sleepSeconds(10);

        movieStream
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6"
        );
    }
}
