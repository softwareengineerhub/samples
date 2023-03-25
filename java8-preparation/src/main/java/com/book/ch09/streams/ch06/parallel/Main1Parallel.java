package com.book.ch09.streams.ch06.parallel;

import java.util.stream.IntStream;

public class Main1Parallel {

  public static void main(String[] args) {
    MyData myData = new MyData();

    int sum = IntStream.range(0,5000).parallel().filter(i->{
      if(i%10==0){
        myData.increase();
        return true;
      }
      return false;
    }).sum();
    System.out.println("sum="+sum);
    System.out.println("counter="+myData);
  }

}
