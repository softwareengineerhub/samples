package com.app;

public class Main {

    public static void main(String[] args) {
        MyTransformer myTransformer = new MyTransformer();
        myTransformer.serialize();
        myTransformer.deserialize();
    }
}
