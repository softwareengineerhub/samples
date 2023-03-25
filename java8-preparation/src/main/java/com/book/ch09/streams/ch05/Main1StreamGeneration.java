package com.book.ch09.streams.ch05;

import java.util.stream.Stream;

public class Main1StreamGeneration {

  public static void main(String[] args) {
    //Stream.iterate(0, i->i+1).forEach(System.out::println);
    Stream.iterate(0, i->i+1).limit(4).forEach(System.out::println);
    System.out.println("-------------");
    Stream.generate(()->{
      Person p = new Person();
      p.setAge(1);
      p.setName("Name1");
      return p;
    }).limit(3).forEach(System.out::println);
  }

  private static class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public Person() {
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
