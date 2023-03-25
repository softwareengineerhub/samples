package com.book.ch09.streams.streampipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main4Find {

  public static void main(String[] args) {

    List<Person> list = new ArrayList();
    list.add(new Person("Name1", 1));
    list.add(new Person("Name2", 2));
    list.add(new Person("Name3", 3));

    boolean res = list.stream().noneMatch(p->p.age>10);
    System.out.println("res="+res);
    res = list.stream().anyMatch(p->p.age>10);
    System.out.println("res="+res);
    res = list.stream().allMatch(p->p.age>10);
    System.out.println("res="+res);

    System.out.println("-------------------------------");
    Optional<Person> optional = list.stream().filter(d->d.age>1).findFirst();
    System.out.println(optional);

    optional = list.stream().filter(d->d.age>1).findAny();
    System.out.println(optional);



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
