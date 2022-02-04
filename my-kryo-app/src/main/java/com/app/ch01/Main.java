package com.app.ch01;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.dat"));
        Input input = new Input(new FileInputStream("file.dat"));

        Object someObject = "Some string";

        kryo.writeClassAndObject(output, someObject);
        output.close();
        System.out.println("After write");

        Object object = kryo.readClassAndObject(input);
        input.close();
        System.out.println("After read");
        System.out.println("object="+object);


    }
}
