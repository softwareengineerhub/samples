package com.book.ch04.datetime.ch01;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main04 {

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        zdt=zdt.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(zdt);
        zdt=zdt.plusMinutes(10);
        System.out.println(zdt);
        zdt=zdt.plusYears(2);
        System.out.println(zdt);
        zdt=zdt.minusWeeks(2);
        System.out.println(zdt);
        zdt=zdt.minusSeconds(40);
        System.out.println(zdt);
        System.out.println("---------------");
        zdt=zdt.withHour(11);
        System.out.println(zdt);
        zdt=zdt.withYear(2027);
        System.out.println(zdt);

    }

}
