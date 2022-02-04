package com.app.ch05.inclass.serializer;

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

        Person3 person = new Person3();
        person.setAge(3);
        person.setName("Name3");

        //kryo.register(Person3.class, new PersonSerializer());

        kryo.writeObject(output, person);
        output.close();
        System.out.println("After write");

        Person3 object = kryo.readObject(input, Person3.class);
        input.close();
        System.out.println("After read");
        System.out.println("object="+object);
    }

}
