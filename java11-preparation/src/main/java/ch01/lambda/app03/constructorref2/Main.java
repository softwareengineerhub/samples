/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app03.constructorref2;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        MyFunctionalInter2 mfi2 = MyData2::new;
        MyData2 myDataA = mfi2.createData2("a", 1);
        MyData2 myDataB = mfi2.createData2("b", 2);
        System.out.println(myDataA);
        System.out.println(myDataB);
    }
    
}
