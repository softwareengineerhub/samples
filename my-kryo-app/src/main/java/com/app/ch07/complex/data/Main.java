package com.app.ch07.complex.data;

import com.app.ch07.complex.data.model.Car;
import com.app.ch07.complex.data.model.Manufacture;
import com.app.ch07.complex.data.model.Meta;
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

        Meta meta = new Meta();
        meta.setYear(1986);

        Manufacture manufacture = new Manufacture();
        manufacture.setPower(10);
        manufacture.setDescription("Description10");
        manufacture.setMeta(meta);

        Car car = new Car();
        car.setName("Name1");
        car.setPrice(20);
        car.setManufacture(manufacture);


        kryo.writeClassAndObject(output, car);
        output.close();
        System.out.println("After write");

        Object object = kryo.readClassAndObject(input);
        input.close();
        System.out.println("After read");
        System.out.println("object="+object);


    }
}
