/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch09.jdbc.sample5.myfilteredrowset;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import javax.sql.rowset.Predicate;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyFilter implements Predicate {

    @Override
    public boolean evaluate(RowSet rs) {
        try {
           // System.out.println("@Evaluate");
            System.out.println("isAfterLast="+rs.isAfterLast());
            int id = rs.getInt("id");
            return (id+2)%2==0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }
    
}
