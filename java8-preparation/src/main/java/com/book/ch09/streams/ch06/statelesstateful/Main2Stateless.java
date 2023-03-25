package com.book.ch09.streams.ch06.statelesstateful;

import java.util.stream.IntStream;

public class Main2Stateless {

  public static void main(String[] args) {
    IntStream stream = IntStream.range(1,11);
    long sum = stream.parallel().mapToLong(n->n).filter(i->i%2==0).sum();
    System.out.println("sum="+sum);
    System.out.println("------------------");
  }

}
