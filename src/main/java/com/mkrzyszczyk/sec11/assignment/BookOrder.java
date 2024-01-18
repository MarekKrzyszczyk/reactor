package com.mkrzyszczyk.sec11.assignment;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class BookOrder {

    private final String title;
    private final String author;
    private final String category;
    private final double price;

    public BookOrder() {
        Book book = Faker.instance().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Faker.instance().commerce().price().replace(",", "."));
    }
}
