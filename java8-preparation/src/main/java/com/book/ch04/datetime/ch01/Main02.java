package com.book.ch04.datetime.ch01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main02 {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse("2023-01-01 12:20", formatter);
        System.out.println("ldt="+ldt);

    }

}
