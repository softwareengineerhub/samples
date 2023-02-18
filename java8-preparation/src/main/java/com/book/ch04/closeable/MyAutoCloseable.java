package com.book.ch04.closeable;

public class MyAutoCloseable implements AutoCloseable {

    public MyAutoCloseable() {
        System.out.println("MyAutoCloseable.open()");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseable.close()");
        String s = null;
        s.toString();
    }
}
