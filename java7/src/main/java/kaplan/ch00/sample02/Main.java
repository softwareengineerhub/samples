/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.ch00.sample02;

import java.io.IOException;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) throws IOException {

        try (MyCloseable myCloseable1 = new MyCloseable("Name1");
                MyCloseable myCloseable2 = new MyCloseable("Name2");) {
            System.out.println("Inside try");
        }

    }

}
