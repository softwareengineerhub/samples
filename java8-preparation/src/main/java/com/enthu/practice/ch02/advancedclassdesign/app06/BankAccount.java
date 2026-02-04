package com.enthu.practice.ch02.advancedclassdesign.app06;

public class BankAccount implements Account {

    public static void main(String[] args) {
        Account account = new BankAccount();
        String id = account.getId();
        System.out.println("id="+id);
    }

}
