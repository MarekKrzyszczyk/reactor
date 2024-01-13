package com.mkrzyszczyk.sec04;

import com.mkrzyszczyk.courseutil.Util;
import com.mkrzyszczyk.sec04.helper.OrderService;
import com.mkrzyszczyk.sec04.helper.UserService;

public class Lec12FlatMap {

    public static void main(String[] args) {

        UserService.getUsers()
                .flatMap(user -> OrderService.getOrder(user.getUserId()))
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        Util.sleepSeconds(60);
    }
}
