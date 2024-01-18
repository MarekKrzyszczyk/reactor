package com.mkrzyszczyk.sec11.assignment;

import com.mkrzyszczyk.courseutil.Util;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Assignment {

    public static void main(String[] args) {

        eventStream()
                .filter(bookOrder -> bookOrder.getCategory().equals("Fantasy")
                        || bookOrder.getCategory().equals("Science Fiction")
                        || bookOrder.getCategory().equals("Suspense/Thriller"))
                .buffer(Duration.ofSeconds(5))
                .map(Assignment::getRevenue)
                .subscribe(revenueMap -> log.info(revenueMap.toString()));

        Util.sleepSeconds(60);
    }

    private static RevenueMap getRevenue(List<BookOrder> bookOrders) {
        Map<String, Double> collect = bookOrders
                .stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory, Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueMap(collect);
    }

    private static Flux<BookOrder> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> new BookOrder());
    }
}
