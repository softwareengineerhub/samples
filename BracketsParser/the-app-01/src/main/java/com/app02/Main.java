package com.app02;

public class Main {

    public static void main(String[] args) {
        SimpleValidator simpleValidator = new SimpleValidator();
        boolean valid = simpleValidator.isValid("2*x+5=17");
        System.out.println("valid="+valid);

        valid = simpleValidator.isValid("2**x+5=17");
        System.out.println("valid="+valid);


    }

}
