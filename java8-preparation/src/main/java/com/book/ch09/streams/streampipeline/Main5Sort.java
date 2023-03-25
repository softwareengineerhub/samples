package com.book.ch09.streams.streampipeline;

import java.util.ArrayList;
import java.util.List;

public class Main5Sort {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));

    //must support Comparable
    list.stream().sorted().forEach(System.out::println);
    System.out.println("-----------------");
    list.stream().sorted((a,b)->a.age-b.age).forEach(System.out::println);
    System.out.println("-----------peek------");
    long count = list.stream().filter(t->true).peek(c->{
      //System.out.println("!!!!!!");
      c.name="QQQQQ";
      //if(c.age<2){
      //  list.remove(0);
      //}
      //System.out.println(c+"ttt");
      //list.remove(0);
    }).count();
    System.out.println("count="+count);
    System.out.println(list);

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
