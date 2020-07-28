package com.app;

import com.app.domain.Person;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person("name1", 1);
        Person person2 = Person.builder().age(2).name("Name2").build();
        System.out.println("person1="+person1);
        System.out.println("person2="+person2);

        System.out.println("----------------");
        Person person3 = new Person();
        person3.setAge(3);
        person3.setName("Name3");
        System.out.println("person3="+person3);
    }

}
