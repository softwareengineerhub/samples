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
public class BasicBinaryTree {

    private Node root;
    private int size;

    public void add(Comparable item) {
        if (root == null) {
            root = new Node(item);
            size++;
            return;
        }
        insert(root, item);
    }

    public void insert(Node node, Comparable value) {
        int flag = node.getItem().compareTo(value);
        if (flag < 1) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
                size++;
                return;
            }
            insert(node.getLeft(), value);
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
                size++;
                return;
            }
            insert(node.getRight(), value);
        }
    }

    public boolean contains(Comparable value) {
        return contains(root, value);
    }

    private boolean contains(Node node, Comparable target) {
        if (node == null) {
            return false;
        }
        int flag = node.getItem().compareTo(target);
        if (flag == 0) {
            return true;
        }
        if (flag > 1) {
            return contains(node.getLeft(), target);
        }
        return contains(node.getRight(), target);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
