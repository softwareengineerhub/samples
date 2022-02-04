package MyDropBookmarks.db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJdbc {

    @Test
    public void test(){
        try(Connection c = getConnection()){
            c.prepareStatement("UPDATE users SET username = 'my-aws-sns' where username  not like 'arn:aws:sns%'").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/wizard_db2?useSSL=false","root","11111111");
    }

}
