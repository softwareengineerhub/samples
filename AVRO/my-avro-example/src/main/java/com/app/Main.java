package com.app;

import example.avro.User;

import java.io.File;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("Alyssa");
        u1.setFavoriteNumber(256);
        User u2 = new User("Ben", 7, "red", ByteBuffer.wrap(new byte[]{7}));

        User u3 = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(null)
                .setMytype(ByteBuffer.wrap(new byte[]{8}))
                .build();

        MyTransformer myTransformer = new MyTransformer();
        myTransformer.serialize(u1, u2, u3);
        myTransformer.deserialize();

        ByteBuffer mytype = u1.getMytype();
        System.out.println("mytype="+mytype);
        System.out.println("--------------");
        mytype = u2.getMytype();
        System.out.println("mytype="+mytype);
    }

}
