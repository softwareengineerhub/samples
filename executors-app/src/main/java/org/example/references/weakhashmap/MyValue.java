package org.example.references.weakhashmap;

public class MyValue {
    private String value;

    public MyValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
