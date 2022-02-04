package com.app.ch02.bulk;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream("file.dat"));
        Input input = new Input(new FileInputStream("file.dat"));

        Object someObject = "Some string";
        Date someDate = new Date();

        kryo.writeObject(output, someObject);
        kryo.writeObject(output, someDate);

        output.close();
        System.out.println("After write");

        someObject = kryo.readObject(input, String.class);
        someDate = kryo.readObject(input, Date.class);
        input.close();
        System.out.println("After read");
        System.out.println("someObject="+someObject);
        System.out.println("someDate="+someDate);
    }
}

