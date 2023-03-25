package com.book.ch09.streams.streampipeline;

import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    /*
    A stream pipeline consists of a source, zero or more intermediate operations and a terminal operation.
    Streams are lazy. Without terminal operations we have everything set up, but does not kick-start data processing
     */
    Stream.of("a", "b", "c").filter(item -> {
      System.out.println("f1=" + item);
      return true;
    }).filter(item -> {
      System.out.println("f2=" + item);
      return true;
    }).count();
  }

}
