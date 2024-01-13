package com.mkrzyszczyk.sec04.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderServiceTest {
    /**
     * Method under test: {@link OrderService#getOrder(int)}
     */
    @Test
    void testGetOrder() {
        assertEquals(Integer.SIZE, OrderService.getOrder(123).getPrefetch());
        assertEquals(Integer.SIZE, OrderService.getOrder(1).getPrefetch());
    }
}

