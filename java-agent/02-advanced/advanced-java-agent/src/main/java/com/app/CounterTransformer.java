package com.app;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class CounterTransformer implements ClassFileTransformer {
    private int count;

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        count++;
        System.out.println("loaded: " + className);
        return classfileBuffer;
    }

    public int getCount() {
        return count;
    }
}
