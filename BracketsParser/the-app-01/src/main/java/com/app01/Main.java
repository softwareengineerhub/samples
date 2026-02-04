package com.app01;

public class Main {

    public static void main(String[] args) {
        String text ="aaa+bbb";

        int plusPosition = text.indexOf("+");
        System.out.println("plusPosition="+plusPosition);

        //String left = text.substring(0, 3);
        String left = text.substring(0, plusPosition);
        System.out.println("text="+text);
        System.out.println("left="+left);

        //+ -->3
        //String right = text.substring(4, text.length());
        String right = text.substring(plusPosition+1);
        System.out.println("right="+right);

    }
}
