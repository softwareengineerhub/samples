package com.app.model;

public class DataModel {
    private String user;
    private String datevalue;
    private String content;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDatevalue() {
        return datevalue;
    }

    public void setDatevalue(String datevalue) {
        this.datevalue = datevalue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "user='" + user + '\'' +
                ", datevalue='" + datevalue + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
