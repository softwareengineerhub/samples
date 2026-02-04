/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enthu.practice.ch06.exceptions.app06;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Boo implements Serializable {
    public transient int age = 10;
    public static int type = 20;
    
}
