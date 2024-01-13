package com.mkrzyszczyk.sec01;

import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Mono;

public class Loc08FromRunnable {

    public static void main(String[] args) {

        //this is useful when we want to be notified about something

        Mono.fromRunnable(processTimeConsumingOperation())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        //this part will be executed as soon as processTimeConsumingOperation() is done
                        () -> System.out.println("process is done"));
    }

    private static Runnable processTimeConsumingOperation() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
