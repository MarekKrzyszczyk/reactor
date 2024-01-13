package com.mkrzyszczyk.sec01;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Loc07FromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.onNext());

        Util.sleepSeconds(1);


    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
