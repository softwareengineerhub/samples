package com.app.ch04.custom.serializer;

import com.app.ch03.serializerdefault.field.serializer.Person;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.dat"));
        Input input = new Input(new FileInputStream("file.dat"));

        Person person = new Person();
        person.setAge(2);
        person.setName("Name2");

        kryo.register(Person.class, new PersonSerializer());

        kryo.writeObject(output, person);
        output.close();
        System.out.println("After write");

        Person object = kryo.readObject(input, Person.class);
        input.close();
        System.out.println("After read");
        System.out.println("object="+object);
    }

}
