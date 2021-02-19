package com.app.jdbi.upsert;

import com.app.jdbc.Person;
import com.app.jdbi.api.PersonDAO;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MyUpsertMain {

    public static void main(String[] args) {
        DBI dbi = new DBI("jdbc:mysql://127.0.0.1:3306/wizard_db2?useSSL=false", "root", "11111111");
        MyPersonDAO dao = dbi.open(MyPersonDAO.class);
        /*dbi.registerMapper(new ResultSetMapper<Person>() {
            @Override
            public Person map(int i, ResultSet rs, StatementContext sc) throws SQLException {
                Person p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                return p;
            }
        });*/

        //1 - for insert
        //2 - for update
        int result = dao.upsert(init4Update(false));
        System.out.println("result="+result);

        result = dao.upsert(init4Update(false));
        System.out.println("result="+result);

        //dao.insert(init4Update());

        long count = dao.countAll();
        System.out.println("count="+count);

       //dao.removeAll();
       // count = dao.countAll();
       // System.out.println("count="+count);

    }

    private static MyPerson init4Update(boolean needUpdate){
        MyPerson myPerson = new MyPerson();
        myPerson.setUserId(4);
        myPerson.setAccountTypeId(4);
        myPerson.setApplicationId(4);
        myPerson.setExtId("extId4-Update");
        myPerson.setRecoveryType("recoveryType4");
        myPerson.setRecoveryId("recoveryId4");
        myPerson.setExpirationTime(new Timestamp(System.currentTimeMillis()));
        myPerson.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        if(needUpdate){
            myPerson.setRecoveryId("someId");
            myPerson.setRecoveryType("someType");
        }
        //UserId, AccountTypeId, ApplicationId, ExtId, RecoveryType, RecoveryId
        //RecoveryType,RecoveryId
        return myPerson;
    }

}
