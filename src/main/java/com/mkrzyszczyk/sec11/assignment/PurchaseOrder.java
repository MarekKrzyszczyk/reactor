package com.mkrzyszczyk.sec11.assignment;

import com.mkrzyszczyk.courseutil.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price().replace(",", "."));
        this.category = Util.faker().commerce().department();
        this.quantity = Util.faker().number().numberBetween(1, 10);
    }
}
