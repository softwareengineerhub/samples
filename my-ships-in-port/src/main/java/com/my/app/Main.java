package com.my.app;

public class Main {

    public static void main(String[] args) {
        MySteps mySteps = new MySteps();
        int[] data = {0,0,0,4};
        int step = mySteps.steps(data);
        System.out.println("step="+step);
    }

}
