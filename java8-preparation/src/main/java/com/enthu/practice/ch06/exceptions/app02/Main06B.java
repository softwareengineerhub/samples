package com.enthu.practice.ch06.exceptions.app02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main06B {

    public static void main(String[] args) {
        try(MyClose1 m1 = new MyClose1();
            MyClose2 m2 = new MyClose2()){
            System.out.println("do action 1");
            System.out.println("do action 2");
        }catch (Exception ex){
            System.out.println("ex: "+ex.getMessage());
            print(ex);
        }finally {
            System.out.println("finally");
        }
    }

    private static void print(Exception ex){

        try(PrintWriter pw = new PrintWriter(new File("out.txt"));) {

            ex.printStackTrace(pw);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
