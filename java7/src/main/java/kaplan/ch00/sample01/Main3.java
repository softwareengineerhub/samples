/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaplan.ch00.sample01;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main3 {

    public static void main(String[] args) throws ParseException {
        String[] sa = {"111.234", "222.5678"};
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        for (String s : sa) {
            System.out.println(nf.parse(s));
        }
    }

}
