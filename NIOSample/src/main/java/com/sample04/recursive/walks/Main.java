/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample04.recursive.walks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author prokopiukd
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Path> list = walk("txt");
        System.out.println("count=" + list.size());
        for (Path path : list) {
            System.out.println(path);
        }
    }

    public static List<Path> walk(String mask) throws IOException {
        Path listDir = Paths.get("C:\\");
        ListTree walk = new ListTree(mask);
        Files.walkFileTree(listDir, walk);
        System.out.println("----------WALK COMPLETED------");
        return walk.collectResults();
    }

}
