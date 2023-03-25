package com.book.ch09.streams.ch06.parallel;

public class MyData {

  private int counter;

  public void increase(){
    counter++;
  }

  @Override
  public String toString() {
    return "MyData{" +
        "counter=" + counter +
        '}';
  }
}
