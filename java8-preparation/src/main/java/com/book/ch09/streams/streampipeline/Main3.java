package com.book.ch09.streams.streampipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main3 {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));

    //long res = list.stream().mapToDouble(p->p.getAge()).count();
    //double res = list.stream().mapToDouble(p->p.getAge()).sum();
    //OptionalDouble res = list.stream().mapToDouble(p->p.getAge()).average();
    //OptionalDouble res = list.stream().mapToDouble(p->p.getAge()).max();
    //OptionalDouble res = list.stream().mapToDouble(p->p.getAge()).min();
    OptionalDouble res = list.stream().mapToDouble(p->p.getAge()).distinct().min();
    System.out.println("res="+res);

    Optional<Person> optionalRes = list.stream().reduce((a,b)->new Person(a.name+b.name, a.age+b.age));
    System.out.println("optionalRes="+optionalRes);
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
