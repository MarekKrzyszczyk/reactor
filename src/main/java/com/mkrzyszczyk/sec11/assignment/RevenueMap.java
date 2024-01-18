package com.mkrzyszczyk.sec11.assignment;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@ToString
public class RevenueMap {

    private LocalDateTime localDateTime = LocalDateTime.now();
    private Map<String, Double> revenueMap;

    public RevenueMap(Map<String, Double> revenueMap) {
        this.revenueMap = revenueMap;
    }
}
