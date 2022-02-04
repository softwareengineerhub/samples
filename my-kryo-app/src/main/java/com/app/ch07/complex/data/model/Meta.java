package com.app.ch07.complex.data.model;

public class Meta {
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "year=" + year +
                '}';
    }
}
