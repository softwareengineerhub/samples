/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basicbinarytree;

/**
 *
 * @author prokopiukd
 *                                          Lincoln
 *               Jefferson                                                Washington
 *      Jackson             Kennedy                                                  Madison
 *  Adams                                                                                   Roosevelt
 * 
 * 
 * 
 */
public class Main {

    public static void main(String[] args) {
        BasicBinaryTree basicBinaryTree = new BasicBinaryTree();
        basicBinaryTree.add("Lincoln");
        basicBinaryTree.add("Jefferson");
        basicBinaryTree.add("Washington");
        basicBinaryTree.add("Kennedy");
        basicBinaryTree.add("Jackson");
        basicBinaryTree.add("Adams");
        basicBinaryTree.add("Madison");
        basicBinaryTree.add("Roosevelt");
        System.out.println("size=" + basicBinaryTree.size());
        System.out.println("contains(Lincoln)=" + basicBinaryTree.contains("Lincoln"));
        System.out.println("contains(Jeferson)=" + basicBinaryTree.contains("Jeferson"));
        System.out.println("contains(Washington)=" + basicBinaryTree.contains("Washington"));
        System.out.println("contains(Kennedy)=" + basicBinaryTree.contains("Kennedy"));
        System.out.println("contains(Jackson)=" + basicBinaryTree.contains("Jackson"));
        System.out.println("contains(Roosevelt)=" + basicBinaryTree.contains("Roosevelt"));
        Node node = basicBinaryTree.intercept("Kennedy", "Lincoln");
        System.out.println("node=" + node.getItem());
        int distance = basicBinaryTree.distance("Kennedy", "Roosevelt");
        System.out.println("distance=" + distance);
    }

}

