package org.example.references.weakhashmap;

import java.util.Objects;

public class MyKey {
    private int key;

    public MyKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return key == myKey.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "key=" + key +
                '}';
    }
}
