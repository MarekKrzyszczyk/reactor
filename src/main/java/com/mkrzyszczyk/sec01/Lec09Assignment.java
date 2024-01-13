package com.mkrzyszczyk.sec01;

import com.mkrzyszczyk.courseutil.Util;
import com.mkrzyszczyk.sec01.assignment.FileService;

public class Lec09Assignment {

    public static void main(String[] args) {

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.write("file03.txt", "This is file 3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file04.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
