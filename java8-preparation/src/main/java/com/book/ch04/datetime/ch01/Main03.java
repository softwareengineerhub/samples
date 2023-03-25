package com.book.ch04.datetime.ch01;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Main03 {

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("US/Pacific"));
        System.out.println("zdt="+zdt);
        System.out.println("--------------");
        Set<String> items= ZoneId.getAvailableZoneIds();
        for(String item: items){
            if("US/Pacific".equals(item)) {
                System.out.println(item);
            }
        }
    }
}
