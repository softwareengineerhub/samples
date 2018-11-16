/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch04.generics.collections.sample4;

import java.util.TreeSet;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for (int i = 324; i <= 328; i++) {
            s.add(i);
        }
        subs = (TreeSet) s.subSet(326, true, 328, true);
        subs.add(329);
        System.out.println(s + " " + subs);

    }

}
