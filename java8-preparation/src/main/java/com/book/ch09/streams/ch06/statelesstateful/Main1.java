package com.book.ch09.streams.ch06.statelesstateful;

import java.util.stream.IntStream;

public class Main1 {

  public static void main(String[] args) {
    IntStream stream = IntStream.range(0,10);
    long sum = stream.limit(5).sum();
    System.out.println("sum="+sum);
    System.out.println("------------------");


    IntStream stream2 = IntStream.range(0,10);
    long sum2 = stream2.limit(5).sum();
    System.out.println("sum2="+sum2);
    System.out.println("------------------");

    //sum and sum2 are same. but it takes more time to process in parallel

  }

}
