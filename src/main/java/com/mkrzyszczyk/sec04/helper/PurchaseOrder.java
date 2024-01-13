package com.mkrzyszczyk.sec04.helper;

import com.mkrzyszczyk.courseutil.Util;
import lombok.Data;

@Data
public class PurchaseOrder {

    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Util.faker().commerce().price();
    }
}
