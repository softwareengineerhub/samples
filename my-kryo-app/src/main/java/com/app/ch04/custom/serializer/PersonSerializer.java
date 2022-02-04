package com.app.ch04.custom.serializer;

import com.app.ch03.serializerdefault.field.serializer.Person;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class PersonSerializer extends Serializer<Person> {

    public void write(Kryo kryo, Output output, Person person) {
        output.writeString(person.getName());
        output.writeInt(person.getAge());
    }

    public Person read(Kryo kryo, Input input, Class<Person> aClass) {
        Person person = new Person();
        person.setName(input.readString());
        person.setAge(input.readInt());
        return person;
    }
}
