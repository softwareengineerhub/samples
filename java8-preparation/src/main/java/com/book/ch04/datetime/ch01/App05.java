package com.book.ch04.datetime.ch01;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class App05 {

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        Period period = Period.ofWeeks(2);
        System.out.println("period="+period);
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        System.out.println(dayOfWeek.getValue());
        //zdt=zdt.with(ChronoField.DAY_OF_WEEK, dayOfWeek.getValue());
        zdt=zdt.withMinute(55);
        System.out.println("zdt="+zdt);

        System.out.println("----------------");
        //ChronoField.ALIGNED_WEEK_OF_MONTH
        //Instant val =Instant.now().with(ChronoField.DAY_OF_WEEK, 2);
        //Instant val =Instant.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        ZonedDateTime val = ZonedDateTime.now();
        val = val.plus(Period.ofWeeks(2));
        System.out.println("val0="+val);
        ZonedDateTime val1=val.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println("val1="+val1);
        ZonedDateTime val2=val.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
        System.out.println("val2="+val2);
        //zdt=zdt.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("------------------------");
        Instant i = Instant.now();
        i = i.plus(Period.ofWeeks(2));
        System.out.println("i0="+i);
        //Instant i1 = i.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        //Instant i1 = i.with(ChronoField.DAY_OF_WEEK, 2);
        //System.out.println("i1="+i1);
    }
}
