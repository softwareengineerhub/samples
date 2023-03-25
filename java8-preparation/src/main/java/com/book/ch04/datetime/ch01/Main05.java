package com.book.ch04.datetime.ch01;

import java.time.Instant;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main05 {

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        Period period = Period.ofMonths(1);
        System.out.println("period="+period);
        zdt=zdt.minus(period);
        System.out.println("zdt="+zdt);




    }
}
