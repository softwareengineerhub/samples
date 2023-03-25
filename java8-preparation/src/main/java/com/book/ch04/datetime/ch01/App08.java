package com.book.ch04.datetime.ch01;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App08 {

    public static void main(String[] args) {

        //Instant.parse("2023-03-09T:17:40:00Z");

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        //LocalDateTime ldt = LocalDateTime.parse("2023-01-01 12:20", formatter);

        //ZonedDateTime zdt = ZonedDateTime.parse("", formatter);

        String instantExpected = "2014-12-22T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));

    }
}
