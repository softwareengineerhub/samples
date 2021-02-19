package com.app.jdbi.upsert;

import org.skife.jdbi.v2.DBI;

import java.sql.Timestamp;

public class MyUpsertMainTest {
    private static final long TIME_NOW = System.currentTimeMillis();
    private static final Timestamp TIMESTAMP_VALUE = new Timestamp(TIME_NOW);


    public static void main(String[] args) {
        DBI dbi = new DBI("jdbc:mysql://127.0.0.1:3306/wizard_db2?useSSL=false", "root", "11111111");
        MyPersonDAO dao = dbi.open(MyPersonDAO.class);
        dao.removeAll();



        //1 - for insert
        //2 - for update
        int result = dao.upsert(initUpdate(false));
        System.out.println("result="+result);

        dbi = new DBI("jdbc:mysql://127.0.0.1:3306/wizard_db2?useSSL=false", "root", "11111111");
        dao = dbi.open(MyPersonDAO.class);

        result = dao.upsert(initUpdate(false));
        System.out.println("result="+result);

        long count = dao.countAll();
        System.out.println("count="+count);

        result = dao.upsert(initUpdate(false));
        System.out.println("result="+result);

    }

    private static MyPerson initUpdate(boolean needUpdate){
        MyPerson myPerson = new MyPerson();
        myPerson.setUserId(4);
        myPerson.setAccountTypeId(4);
        myPerson.setApplicationId(4);
        myPerson.setExtId("extId4-Update");
        myPerson.setRecoveryType("recoveryType4");
        myPerson.setRecoveryId("recoveryId4");
        myPerson.setExpirationTime(TIMESTAMP_VALUE);
        myPerson.setCreatedDate(TIMESTAMP_VALUE);
        if(needUpdate){
         //   myPerson.setRecoveryId("someId");
         //   myPerson.setRecoveryType("someType");
        }
        myPerson.setLastModifiedDate(new Timestamp(TIME_NOW));
        myPerson.setModifiedBy("test");
        //UserId, AccountTypeId, ApplicationId, ExtId, RecoveryType, RecoveryId
        //RecoveryType,RecoveryId
        return myPerson;
    }

}
