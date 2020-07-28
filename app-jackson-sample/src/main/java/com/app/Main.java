package com.app;

import com.app.domain.Person;
import com.app.domain.Person2;
import com.app.domain.Person3;
import com.app.domain.Person4;
import com.app.jsonview.MyView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        String json = mapper.writeValueAsString(person);
        System.out.println("json="+json);
        System.out.println("-----------------------");
        Person2 p2 = new Person2();
        p2.setName("Name2");
        p2.setAge(2);
        json = mapper.writeValueAsString(p2);
        System.out.println("json="+json);
        System.out.println("-----------------------");
        Person3 p3 = new Person3();
        p3.setName("Name3");
        p3.setAge(3);
        p3.setDate(new Date());
        json = mapper.writeValueAsString(p3);
        System.out.println("json="+json);
        System.out.println("-----------------------");
        Person4 p4 = new Person4();
        p4.setName("Name4");
        p4.setAge(4);
        p4.setDate(new Date());
        json = mapper.writerWithView(MyView.C.class).writeValueAsString(p4);
        System.out.println("json="+json);
    }
}
