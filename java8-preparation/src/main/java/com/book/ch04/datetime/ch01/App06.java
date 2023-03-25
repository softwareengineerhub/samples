package com.book.ch04.datetime.ch01;

import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class App06 {

    public static void main(String[] args) {
        //ChronoField.ALIGNED_WEEK_OF_MONTH
        //Instant val =Instant.now().with(ChronoField.DAY_OF_WEEK, 2);
        //Instant val =Instant.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        ZonedDateTime val = ZonedDateTime.now();
        val = val.plus(Period.ofMonths(2));
        System.out.println("val0="+val);
        ZonedDateTime val1=val.withDayOfMonth(2);
        System.out.println("val1="+val1);
        ZonedDateTime val2=val.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("val2="+val2);

    }
}
