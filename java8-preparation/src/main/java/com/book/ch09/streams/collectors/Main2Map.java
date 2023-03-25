package com.book.ch09.streams.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2Map {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));
    list.add(new Person("Name3-2", 3));

    Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
    System.out.println(map);

    Map<Integer, List<Person>> map2 = list.stream().collect(Collectors.groupingBy(p->p.age));
    System.out.println(map2);

    Map<Integer, Long> map3 = list.stream().collect(Collectors.groupingBy(p->p.age, Collectors.counting()));
    System.out.println(map3);

    Map<Integer, List<String>> map4 = list.stream()
        .collect(Collectors.groupingBy(p->p.age, Collectors.mapping(p->p.getName(), Collectors.toList())));
    System.out.println(map4);

    Map<Boolean, List<Person>> map5 = list.stream().collect(Collectors.partitioningBy(p->p.age>2));
    System.out.println(map5);
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
