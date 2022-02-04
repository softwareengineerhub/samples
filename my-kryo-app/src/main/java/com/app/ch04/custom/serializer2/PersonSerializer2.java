package com.app.ch04.custom.serializer2;

import com.app.ch03.serializerdefault.field.serializer.Person;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class PersonSerializer2 extends Serializer<Person2> {

    public void write(Kryo kryo, Output output, Person2 person) {
        output.writeString(person.getName());
        output.writeInt(person.getAge());
    }

    public Person2 read(Kryo kryo, Input input, Class<Person2> aClass) {
        Person2 person = new Person2();
        person.setName(input.readString());
        person.setAge(input.readInt());
        return person;
    }
}
