package com.book.ch04.closeable;

import java.io.Closeable;
import java.io.IOException;

public class MyCloseable implements Closeable {

    public MyCloseable() {
        System.out.println("MyCloseable.open()");
    }

    @Override
    public void close() throws IOException {
        System.out.println("MyCloseable.close()");
    }
}
