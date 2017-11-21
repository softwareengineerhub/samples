/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

/**
 *
 * @author prokopiukd
 */
public class TreeMain {
    
    public static void main(String[] args) {
        BasicBinaryTree basicBinaryTree = new BasicBinaryTree();
        basicBinaryTree.add("Lincoln");
        basicBinaryTree.add("Jeferson");
        basicBinaryTree.add("Washington");
        basicBinaryTree.add("Kennedy");
        basicBinaryTree.add("Jackson");
        basicBinaryTree.add("Adams");
        basicBinaryTree.add("Roosevelt");
        System.out.println(basicBinaryTree);
    }
    
}
