package com.book.ch09.streams.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3Map {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));
    list.add(new Person("Name3-2", 3));

    Map<Integer, Integer> map = list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.summingInt(p->p.age)));
    System.out.println(map);

    Map<Integer, Double> map2 = list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.averagingInt(p->p.age)));
    System.out.println(map2);
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
