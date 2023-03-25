package com.book.ch09.streams.streamofstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1StreamOfStreams {

  public static void main(String[] args) {
    List<String> list = new ArrayList();
    list.add("a;b;c;d;e");
    list.add("f;g;h;k;l");
    list.add("m;n;o;p;q");
    long count = list.stream().map(text->text.split(";")).count();
    System.out.println("count="+count);
    Stream<String[]> data = list.stream().map(text->text.split(";"));

    count = list.stream().flatMap(text->Stream.of(text.split(";"))).count();
    System.out.println("count="+count);
    List<String> stringList = list.stream().flatMap(text->Stream.of(text.split(";"))).collect(Collectors.toList());
    System.out.println(stringList);
  }

}
