/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redis.ch00.string;

import redis.clients.jedis.Jedis;

/**
 *
 * @author denis
 */
public class Main {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost 
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //set the data in redis string 
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it 
        System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));
    }

}
