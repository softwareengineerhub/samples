package com.app;

import example.avro.User;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("Alyssa");
        u1.setFavoriteNumber(256);
        User u2 = new User("Ben", 7, "red");

        User u3 = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(null)
                .build();

        MyTransformer myTransformer = new MyTransformer();
        myTransformer.serialize(u1, u2, u3);
        myTransformer.deserialize();
    }

}
