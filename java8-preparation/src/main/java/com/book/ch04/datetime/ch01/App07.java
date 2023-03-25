package com.book.ch04.datetime.ch01;

import java.time.Instant;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class App07 {

    public static void main2(String[] args) {
        Instant a = Instant.now();
        System.out.println(a);
        //a =a.plus(Period.ofMonths(2)).with(TemporalAdjusters.lastDayOfMonth());
        a =a.plus(Period.ofMonths(2));//.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(a);
    }

    public static void main(String[] args) {
        //ChronoField.ALIGNED_WEEK_OF_MONTH
        //Instant val =Instant.now().with(ChronoField.DAY_OF_WEEK, 2);
        //Instant val =Instant.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        Instant a = Instant.now();
        System.out.println(a);
        Instant i = a.plus(2, ChronoUnit.HOURS);
        System.out.println(a);
        System.out.println(i);
        System.out.println(Instant.now().plus(2, ChronoUnit.HOURS));

    }
}
