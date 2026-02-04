package com.enthu.practice.ch02.advancedclassdesign.app06;

public interface Account {

    public default String getId() {
        return "0000";
    }

}
