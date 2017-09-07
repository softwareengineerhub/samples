/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithm.tasks.list.revert;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Denis
 */
public class ListRevert {

    public void revert(List list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Object head = list.get(i);
            Object tail = list.set(list.size() - 1 - i, head);
            list.set(i, tail);
        }
    }

    public static void main(String[] args) {
        ListRevert listRevert = new ListRevert();
        List list = Arrays.asList(1, 2, 3, 4, 5, 6);
        listRevert.revert(list);
        System.out.println(list);
    }

}
