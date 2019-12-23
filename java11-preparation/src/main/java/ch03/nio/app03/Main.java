/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.nio.app03;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        File file = new File("somefile.txt");
        
        FileSystem fs = FileSystems.getDefault();
        PathMatcher pathMatcher = fs.getPathMatcher("glob:**.[xml,json]");
        boolean res = pathMatcher.matches(Paths.get(file.toURI()));
        System.out.println(res);
        
        pathMatcher = fs.getPathMatcher("glob:**.[txt]");
        res = pathMatcher.matches(Paths.get(file.toURI()));
        System.out.println(res);
    }
    
}
