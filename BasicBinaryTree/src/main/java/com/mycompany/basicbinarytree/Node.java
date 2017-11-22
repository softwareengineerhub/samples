/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basicbinarytree;

/**
 *
 * @author prokopiukd
 */
public class Node {

    private Node parent;
    private Node left;
    private Node right;
    private Comparable item;

    public Node(Comparable item) {
        this.item = item;
    }
    
    

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Comparable getItem() {
        return item;
    }

    public void setItem(Comparable item) {
        this.item = item;
    }

}
