/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Item {

    private Date date;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public Item(Date date, double sum, double avg, double min, double max) {
        this.date = date;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public Item() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.sum) ^ (Double.doubleToLongBits(this.sum) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.avg) ^ (Double.doubleToLongBits(this.avg) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.min) ^ (Double.doubleToLongBits(this.min) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.max) ^ (Double.doubleToLongBits(this.max) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.sum) != Double.doubleToLongBits(other.sum)) {
            return false;
        }
        if (Double.doubleToLongBits(this.avg) != Double.doubleToLongBits(other.avg)) {
            return false;
        }
        if (Double.doubleToLongBits(this.min) != Double.doubleToLongBits(other.min)) {
            return false;
        }
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(other.max)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "date=" + date + ", sum=" + sum + ", avg=" + avg + ", min=" + min + ", max=" + max + '}';
    }
    
    

}
