package com.app06.mythreadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {

    public ThreadLocal<AtomicInteger> value = ThreadLocal.withInitial(()->new AtomicInteger(1));
    public AtomicInteger value2=new AtomicInteger(2);


}
