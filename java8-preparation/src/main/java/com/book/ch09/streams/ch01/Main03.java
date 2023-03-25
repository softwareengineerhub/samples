package com.book.ch09.streams.ch01;

import java.util.Arrays;

public class Main03 {

  public static void main(String[] args) {
    Integer[] array = {1,2,3};
    long count = Arrays.asList(array).stream().filter(i->i>1).count();
    System.out.println("count="+count);

  }

}
