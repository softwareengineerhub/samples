package com.enthu.practice.ch09.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.plusDays(4);
        long between = ChronoUnit.DAYS.between(ldt1, ldt2);
        System.out.println(between);
        Duration d = Duration.ofMillis(1100);
        System.out.println(d);
        d = Duration.ofSeconds(61);
        System.out.println(d);
        System.out.println("-------------");
        //Instant i = Instant.now().truncatedTo(DAYS);
        Instant i = Instant.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println("i="+i);
        ZonedDateTime zdt = ZonedDateTime.now();
        zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(""));
        Set<String> all = ZoneId.getAvailableZoneIds();
        System.out.println("-------------");
    }

}
