/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample05.watch.tree;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author prokopiukd
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        MonitorTree monitorTree = new MonitorTree();
        Path path = Paths.get("C:\\Denis");
        monitorTree.watchRNDir(path);
    }
    
}
