package com.book.ch09.streams.ch06.statelesstateful;

import java.util.stream.IntStream;

public class Main3Ordered {

  //Calling unordered() doesn’t change the ordering of the stream; it just
  //unsets that ORDERED bit so the stream doesn’t have to maintain the ordering
  //state.
  public static void main(String[] args) {
    IntStream stream = IntStream.range(1,11);
    long sum = stream.unordered().parallel().mapToLong(n->n).filter(i->i%2==0).sum();
    System.out.println("sum="+sum);
    System.out.println("------------------");
  }

}
