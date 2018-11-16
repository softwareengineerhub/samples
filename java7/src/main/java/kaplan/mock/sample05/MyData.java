/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.mock.sample05;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyData {
    
    public void useLocalClass(){
        
        
        //Not compile
        /*private class LocalClass{
            
        }*/
        
        /*public class LocalClass{
            
        }*/
        
        
        class LocalClass {
            
            private void print(){
                System.out.println("local");
            }
        }
        
        new LocalClass().print();
        
    }
    
}
