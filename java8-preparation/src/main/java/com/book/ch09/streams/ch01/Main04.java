package com.book.ch09.streams.ch01;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main04 {

  public static void main(String[] args) throws Exception {
    Stream<Integer> stream = Stream.of(1,2,3);
    //stream.forEach(item-> System.out.println(item));
    stream.forEach(System.out::println);

    System.out.println("-----------");
    DoubleStream.of(1,2,3).findFirst().getAsDouble();

  }

}
