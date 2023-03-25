package com.book.ch09.streams.collectors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main1List {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));

    List<Person> result = list.stream().filter(p -> p.age > 1).collect(Collectors.toList());
    System.out.println(result);
    System.out.println(result.getClass());
    LinkedList result2 = list.stream().filter(p -> p.age > 1).collect(Collectors.toCollection(LinkedList::new));
    System.out.println(result2);
    System.out.println(result2.getClass());
    System.out.println("-----------------");


  }

  private static class Person implements Comparable<Person> {

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

    @Override
    public int compareTo(Person p) {
      return -(age - p.age);
    }
  }

}
