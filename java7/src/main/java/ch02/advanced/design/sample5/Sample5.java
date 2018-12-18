/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.advanced.design.sample5;

import com.sun.media.sound.SoftAbstractResampler;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Sample5 {

    public enum A {
        V1, V2, V3;
                
        static {
            System.out.println("Static "+System.currentTimeMillis());            
        }
        
        {
            System.out.println("Non static. hashCode="+hashCode());
        }
        
        
    }

}
