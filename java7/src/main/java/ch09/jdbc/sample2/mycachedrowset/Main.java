/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample2.mycachedrowset;


/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        MyCachedRowSetDAO dao = new MyCachedRowSetDAO();
        dao.makeCall();
    }
    
    
}
