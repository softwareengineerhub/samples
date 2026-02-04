package com.enthu.practice.ch02.advancedclassdesign.app06;

import java.util.ArrayList;
import java.util.Collections;

public class BankAccount2 implements PremiumAccount {

    public static void main(String[] args) {
        Account account = new BankAccount2();
        String id = account.getId();
        System.out.println("id="+id);
        ArrayList<String> list = new ArrayList<>();
        list.add("1a");
        list.add("1A");
        list.add("b");
        list.add("c");
        Collections.sort(list);
        System.out.println(list);
    }


    //will not compile without this method
    @Override
    public String getId() {
        return null;
    }
}
