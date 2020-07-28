package com.app.domain;

import com.app.jsonview.MyView;
import com.app.serializer.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Person4 {
    @JsonView(value = MyView.A.class)
    private String name;
    @JsonView(value = MyView.B.class)
    private int age;
    @JsonView(value = {MyView.C.class, MyView.A.class})
    private Date date;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
