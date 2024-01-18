package com.mkrzyszczyk.sec11.assignment;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@ToString
public class RevenueMap {

    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final Map<String, Double> revenueReport;

    public RevenueMap(Map<String, Double> revenueMap) {
        this.revenueReport = revenueMap;
    }
}