package com.mkrzyszczyk.sec01;

import com.mkrzyszczyk.Car;
import com.mkrzyszczyk.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // Use just (that behaves as publisher) only when you have data already
        // In this example getName() method is invoked, despite we don't have any subscribers
        // It is called hot publisher (similar to eager loading). We get data while initializing Mono object
        // All subscribers will get the same data
//        Mono<String> mono = Mono.just(getName());

        // In this example getName() method isn't invoked, nothing happens until somebody subscribes
        // It is called cold publisher (similar to lazy loading). We get data while subscribing
        // All subscribers will get different data
//        Supplier<String> stringSupplier = () -> getName();
//        Mono<String> mono = Mono.fromSupplier(stringSupplier);
//        mono.subscribe(
//                Util.onNext()
//        );
//
//        Callable<String> stringCallable = () -> getName();
//        Mono.fromCallable(stringCallable)
//                .subscribe(
//                    Util.onNext()
//            );

//        getCar().subscribe();
        getCar();
    }

    private static Mono<String> getName() {
        System.out.println("Generating name...");
        return Mono.just(Util.faker().name().fullName());
    }

    private static void getCar() {
        Car car = new Car(1L, "Ford");
        Mono.just(car)
                .<Car>handle((c, synchronousSink) -> {
                    if (c.getId() < 2l) {
                        getName()
                                .subscribe(System.out::println);
                        synchronousSink.next(c);
                    }
                })
                .map(car1 -> car1.getBrand())
                .subscribe(car1 -> System.out.println(car.getBrand()));
    }
}
