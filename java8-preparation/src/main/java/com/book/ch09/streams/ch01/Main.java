package com.book.ch09.streams.ch01;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Integer[] array = {1,2,3};
    Stream<Integer> stream = Arrays.stream(array);
    System.out.println(stream);
    long count = stream.count();
    System.out.println("count="+count);

    //count is termianl operation --> no more actions related to streams are available
    //stream.findAny();  - java.lang.IllegalStateException: stream has already been operated upon or closed


    //intermediate operations you can perform between the source and the end of the stream
    //intermediate operations always produce another stream

    //in Java a stream is an object that gets its data from a source, but it does not store any data itself.
    //The stream ends when we use terminal operations


  }

}
