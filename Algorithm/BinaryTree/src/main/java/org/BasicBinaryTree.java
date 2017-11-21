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
public class BasicBinaryTree {
    
    private Node root;
    private int size;
    
    public BasicBinaryTree() {
    }
    
    public void add(Comparable item) {
        if (root == null) {
            root = new Node(item);
            size++;
            return;
        }        
        insert(root, new Node(item));
    }
    
    private void insert(Node parent, Node child) {
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            //if the left node is null, we have found our spot
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                size++;
            } else {
                //otherwise we need to call insert again and test for left or right (recursion)
                insert(parent.getLeft(), child);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(child);
                size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(root==null){
            return "";
        }
        Node left = root.getLeft();
        Node right = root.getRight();
        while(left!=null){
            sb.append(root.getItem());
            sb.append("\n");
            sb.append(left.getItem());
            sb.append("\t");
            sb.append(right.getItem());        
        }
        return sb.toString();
    }
    
    
    
}
