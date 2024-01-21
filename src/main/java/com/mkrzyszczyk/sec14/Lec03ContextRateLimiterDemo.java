package com.mkrzyszczyk.sec14;

import com.mkrzyszczyk.sec14.helper.BookService;
import com.mkrzyszczyk.sec14.helper.UserService;
import lombok.extern.slf4j.Slf4j;
import reactor.util.context.Context;

@Slf4j
public class Lec03ContextRateLimiterDemo {

    public static void main(String[] args) {

        BookService
                .getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(log::info);
    }
}