/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotation;

import com.common.interfaces.CompactDisk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author denys
 */
public class AnnotationMain {

    public static void main(String[] args) {        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/annotation/annotation-config.xml");        
        CompactDisk compactDisk = ctx.getBean(CompactDisk.class);
        compactDisk.play();
    }

}
