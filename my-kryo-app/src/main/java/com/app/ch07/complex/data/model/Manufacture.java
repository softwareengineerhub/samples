package com.app.ch07.complex.data.model;

public class Manufacture {
    private String description;
    private int power;
    private Meta meta;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "description='" + description + '\'' +
                ", power=" + power +
                ", meta=" + meta +
                '}';
    }
}
