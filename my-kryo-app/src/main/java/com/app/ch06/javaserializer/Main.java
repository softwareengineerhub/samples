package com.app.ch06.javaserializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.dat"));
        Input input = new Input(new FileInputStream("file.dat"));

        kryo.register(MyPerson.class, new JavaSerializer());

        MyPerson myPerson = new MyPerson();
        myPerson.setAge(4);
        myPerson.setName("Name4");

        kryo.writeObject(output, myPerson);
        output.close();
        System.out.println("After write");

        myPerson = kryo.readObject(input, MyPerson.class);
        input.close();
        System.out.println("After read");
        System.out.println("myPerson="+myPerson);
    }

}
