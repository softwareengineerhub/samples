package com.book.ch04.datetime.ch01;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main06 {

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(12, 17, 32);
        LocalTime endTime = LocalTime.of(13, 35, 56);
        long betweenMinutes = ChronoUnit.MINUTES.between(startTime, endTime);
        System.out.println("betweenMinutes=" + betweenMinutes);
        Duration duration = Duration.ofMinutes(betweenMinutes);
        System.out.println(duration);
        boolean isBefore = startTime.isBefore(endTime);
        System.out.println("isBefore=" + isBefore);


    }
}
