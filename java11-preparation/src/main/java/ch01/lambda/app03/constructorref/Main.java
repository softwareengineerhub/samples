/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app03.constructorref;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        MyFunctionalInter mfi = MyData::new;
        MyData myData = mfi.createData();
        System.out.println(myData);
    }
    
}
