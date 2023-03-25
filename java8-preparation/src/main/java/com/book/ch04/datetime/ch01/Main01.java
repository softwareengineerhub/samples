package com.book.ch04.datetime.ch01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main01 {

    public static void main(String[] args) {
        LocalDate d1 = LocalDate.now();
        LocalTime t1 = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(d1, t1);
        System.out.println("ldt="+ldt);
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println("ldt2="+ldt2);

        System.out.println("-----------------------------------------");
        //java.time.DateTimeException: Invalid value for MonthOfYear (valid values 1 - 12): 13
        //LocalDate d2 = LocalDate.of(2017, 13, 01);
        LocalDate d2 = LocalDate.of(2017, 1, 01);
        System.out.println("d2="+d2);
        LocalDate d3 = LocalDate.parse("2017-01-01");
        System.out.println("d3="+d3);


        System.out.println("-----------------------------------------");
        //.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 24
        //LocalTime t2 = LocalTime.of(24,2,3);
        LocalTime t2 = LocalTime.of(1,2,3);
        System.out.println("t2="+t2);
        //DateTimeParseException: Text '1:2:3' could not be parsed at index 0
        //LocalTime t3 = LocalTime.parse("1:2:3");
        LocalTime t3 = LocalTime.parse("01:02:03");
        System.out.println("t3="+t3);



    }

}
