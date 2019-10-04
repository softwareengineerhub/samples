/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app02.streamcreation.sub02;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream();
        /*stream.filter(new Predicate<Integer>(){
            
            @Override
            public boolean test(Integer t) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });*/
        
        //stream.filter(t->t%2==0);
        stream.filter(t->{
            System.out.println("t="+t);
            return true;}).filter(t->{
            System.out.println("t="+t);
            return true;}).count();
        
        
    }
    
}
