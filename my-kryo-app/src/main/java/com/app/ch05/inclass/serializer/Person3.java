package com.app.ch05.inclass.serializer;

import com.app.ch04.custom.serializer2.Person2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class Person3 implements KryoSerializable {

    private String name;
    private int age;

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
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void write(Kryo kryo, Output output) {
        output.writeString(name);
        output.writeInt(age);
    }

    public void read(Kryo kryo, Input input) {
        setName(input.readString());
        setAge(input.readInt());
    }
}
