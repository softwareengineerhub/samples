/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample2.mycachedrowset;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyListener2 implements RowSetListener {

    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("@rowSetChanged");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("@rowChanged");
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("@cursorMoved");
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 10000) {
        }
    }

}
