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

    public int distance(Comparable a, Comparable b) {
        Node aNode = findNodeByValue(root, a);
        Node bNode = findNodeByValue(root, b);
        Node common = intercept(aNode, bNode);
        if(common==null){
            throw new RuntimeException("No interceptions were found");
        }
        int aHeight = height(common, aNode);
        int bHeight = height(common, bNode);
        return aHeight + bHeight;
    }

    private int height(Node from, Node to) {
        int h = 0;
        Node tmp = from;
        while (tmp != null) {
            int flag = tmp.getItem().compareTo(to.getItem());
            if (flag == 0) {
                return h;
            }
            if (flag > 0) {
                tmp = tmp.getRight();
                h++;
            } else {
                tmp = tmp.getLeft();
                h++;
            }
        }
        throw new RuntimeException("Could not calculate height");
        //return h;
    }

    public Node intercept(Comparable a, Comparable b) {
        Node aNode = findNodeByValue(root, a);
        Node bNode = findNodeByValue(root, b);
        return intercept(aNode, bNode);
    }

    private Node intercept(Node aNode, Node bNode) {
        Node node = bNode;
        while (node != null) {
            Node tmp = aNode;
            while (tmp != null) {
                if (tmp.getItem().equals(node.getItem())) {
                    return tmp;
                }
                tmp = tmp.getParent();
            }
            node = node.getParent();
        }
        return null;
    }

    private Node findNodeByValue(Node node, Comparable value) {
        if (node == null) {
            return null;
        }
        int flag = node.getItem().compareTo(value);
        if (flag == 0) {
            return node;
        }
        if (flag < 1) {
            return findNodeByValue(node.getLeft(), value);
        } else {
            return findNodeByValue(node.getRight(), value);
        }
    }

    public void add(Comparable item) {
        if (root == null) {
            root = new Node(item);
            size++;
            return;
        }
        insert(root, item);
    }

    private void insert(Node node, Comparable value) {
        int flag = node.getItem().compareTo(value);
        if (flag < 0) {
            if (node.getLeft() == null) {
                Node tmp = new Node(value);
                node.setLeft(tmp);
                tmp.setParent(node);
                size++;
                return;
            }
            insert(node.getLeft(), value);
        } else {
            if (node.getRight() == null) {
                Node tmp = new Node(value);
                node.setRight(tmp);
                tmp.setParent(node);
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
