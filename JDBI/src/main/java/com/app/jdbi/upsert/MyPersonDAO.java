package com.app.jdbi.upsert;


import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MyPersonDAO {

    @SqlUpdate("insert into myperson " +
            "(userId, extId, accountTypeId, applicationId, recoveryType, recoveryId, expirationTime, createdDate, lastModifiedDate, modifiedBy)" +
            " values(:myPerson.userId,:myPerson.extId,:myPerson.accountTypeId,:myPerson.applicationId,:myPerson.recoveryType,:myPerson.recoveryId,:myPerson.expirationTime,:myPerson.createdDate,:myPerson.lastModifiedDate,:myPerson.modifiedBy)" +
            " ON DUPLICATE KEY UPDATE " +
            " userId=:myPerson.userId, applicationId=:myPerson.applicationId, extId=:myPerson.extId," +
            " accountTypeId=:myPerson.accountTypeId, expirationTime=:myPerson.expirationTime," +
            " recoveryId=:myPerson.recoveryId, recoveryType=:myPerson.recoveryType")
    int upsert(@BindBean("myPerson") MyPerson myPerson);

    @SqlQuery("select count(*) from myperson")
    long countAll();

    @SqlUpdate("delete from myperson")
    void removeAll();

}


