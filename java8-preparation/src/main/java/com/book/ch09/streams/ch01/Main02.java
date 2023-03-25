package com.book.ch09.streams.ch01;

import java.util.Arrays;

public class Main02 {

  public static void main(String[] args) {
    Integer[] array = {1,2,3};
    long count = Arrays.stream(array).filter(i->i>1).count();
    System.out.println("count="+count);

    System.out.println("---------------");
    count = Arrays.stream(array).filter(i->i>2).count();
    System.out.println("count="+count);

  }

}
