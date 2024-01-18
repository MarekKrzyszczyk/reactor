package com.mkrzyszczyk.sec10;

import com.mkrzyszczyk.courseutil.Util;
import com.mkrzyszczyk.sec10.helper.AmericanFlights;
import com.mkrzyszczyk.sec10.helper.EmiratesFlights;
import com.mkrzyszczyk.sec10.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(QatarFlights.getFlights(), AmericanFlights.getFlights(), EmiratesFlights.getFlights());

        merge.subscribe(System.out::println);

        Util.sleepSeconds(10);
    }
}
