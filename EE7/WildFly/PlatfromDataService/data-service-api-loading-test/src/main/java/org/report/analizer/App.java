/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.report.analizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author denys.prokopiuk
 */
public class App {

    public static void main(String[] args) throws Exception {
        Reader r = new FileReader("C:\\Denis\\Performance\\10.txt");
        BufferedReader reader = new BufferedReader(r);
        int sum = 0;
        double timeMax = 0;
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains("amount of inserts:")) {
                String[] array = line.split(":");
                int amount = Integer.parseInt(array[1].trim());
                sum += amount;
            } else if (line.contains("SumOfTime:")) {
                String[] array = line.split(":");
                double duration = Double.parseDouble(array[1].trim());
                if (duration > timeMax) {
                    timeMax = duration;
                }
            }
        }
        System.out.println("sum=" + sum);
        System.out.println("max.time=" + timeMax);
        System.out.println(sum / (timeMax / 1000));
    }

}
