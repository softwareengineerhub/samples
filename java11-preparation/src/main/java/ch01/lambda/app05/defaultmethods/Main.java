/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01.lambda.app05.defaultmethods;

/**
 *
 * @author DProkopiuk
 */
public class Main {
        
    public static void main(String[] args) {
        MyInter myInter = new MyInter() {
            @Override
            public long getId() {
                return 1;
            }

            @Override
            public void doAction() {
                System.out.println("doAction().Child");
            }
            
            
        };        
        MyInter myInter2 = () -> 1;        
        System.out.println("---------------------");
        
        myInter.doAction();
        myInter2.doAction();
        
    }
    
}
