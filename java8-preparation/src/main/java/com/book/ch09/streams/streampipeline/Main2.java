package com.book.ch09.streams.streampipeline;

import java.util.stream.Stream;

public class Main2 {

  public static void main(String[] args) {
    /*
    peek() is not terminal
     */
    Stream.of("a", "b", "c").filter(item -> {
      System.out.println("f1=" + item);
      return true;
    }).filter(item -> {
      System.out.println("f2=" + item);
      return true;
    }).peek(item-> System.out.println("peek: "+item)).count();
  }

}
