/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample04.recursive.walks;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author prokopiukd
 */
public class App {

    public static void main(String[] args) throws URISyntaxException {
        URL url = App.class.getResource("/data/nio-data.txt");
        Path path = Paths.get(url.toURI());
        System.out.println(path.toString().endsWith(".txt"));
        Path path1 = Paths.get("nio.txt");
        System.out.println(path.endsWith(path1));
    }

}
