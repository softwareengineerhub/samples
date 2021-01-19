package com.my.app;

import java.util.Arrays;

public class MySteps {

    public int steps(int[] data){
        int amountOfSteps = 0;
        int sum = sum(data);
        if(sum<data.length){
            return -1;
        }
        if(sum%data.length!=0){
            return -1;
        }
        double avg = sum/data.length;
        while(true) {
            Arrays.sort(data);
            boolean needToMakeAction = true;
            for (int i = 0; i < data.length; i++) {
                if (data[i] != avg) {
                    data[i]++;
                    data[data.length - 1]--;
                    amountOfSteps++;
                    needToMakeAction = false;
                    break;
                }
            }
            if(needToMakeAction){
                break;
            }
        }
        return amountOfSteps;
    }


    private int sum(int[] data){
        int sum = 0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
        }
        return sum;
    }

}
