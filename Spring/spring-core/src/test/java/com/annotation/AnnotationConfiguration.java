/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author denys
 */
@Configuration
@ComponentScan(basePackages = {"com.mkyong.examples.spring"})
public class AnnotationConfiguration {
    
}
