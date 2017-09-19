/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.builder;

/**
 *
 * @author prokopiukd
 */
public class Data {

    private final String name;
    private final int amount;

    private Data(Builder builder) {
        name = builder.name;
        amount = builder.amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder {

        private String name;
        private int amount;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Data build(int amount) {
            this.amount = amount;
            return new Data(this);
        }

    }
}
