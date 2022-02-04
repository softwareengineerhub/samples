package com.app.ch04.custom.serializer2;

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

        Person2 person = new Person2();
        person.setAge(2);
        person.setName("Name2");

        //kryo.register(Person3.class, new PersonSerializer());

        kryo.writeObject(output, person);
        output.close();
        System.out.println("After write");

        Person2 object = kryo.readObject(input, Person2.class);
        input.close();
        System.out.println("After read");
        System.out.println("object="+object);
    }

}
