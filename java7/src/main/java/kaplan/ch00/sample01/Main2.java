/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.ch00.sample01;

import java.util.Scanner;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main2 {

    
    public static void main2(String[] args) {
        String in = "1 a 10 . 100 1000";
        Scanner s = new Scanner(in);
        int accum = 0;
        for (int x = 0; x < 4; x++) {
            String t=s.next();
            System.out.println(t);
            //accum +=t; 
        }
        System.out.println(accum);
    }
    
    public static void main(String[] args) {
        String in = "1 a 10 . 100 1000";
        Scanner s = new Scanner(in);
        int accum = 0;
        for (int x = 0; x < 4; x++) {
            int t=-1;
            try{
                t=s.nextInt();
            }catch(Exception ex){
                String res=s.next();
                System.out.println("exception:"+res);
                continue;
            }                
            System.out.println(t);
            accum +=t; 
        }
        System.out.println(accum);
    }

}
