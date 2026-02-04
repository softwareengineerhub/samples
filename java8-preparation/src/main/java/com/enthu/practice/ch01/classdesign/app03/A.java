package com.enthu.practice.ch01.classdesign.app03;

import java.io.IOException;

public class A {

    byte getStatusCode(Object obj) throws NullPointerException {
        if(obj!=null){
            return 127;
        }
        else return -1;
    }

    public void m() throws IOException {

    }

}
