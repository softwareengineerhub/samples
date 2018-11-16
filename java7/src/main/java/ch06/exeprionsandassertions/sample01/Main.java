/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch06.exeprionsandassertions.sample01;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        getItDone(-4);
    }

    public static void getItDone(int counter) {
        assert counter < 100 : "Greater than 100";
        for (int i = counter; i > 0; i--) {
        }
    }

}
