/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.processor;

import com.aggregation.model.Item;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class AggregationProcessorImpl implements AggregationProcessor {

    @Override
    public Item process(List<Item> items) {
        double sum = 0;
        double avg = 0;
        double min = 0;
        double max = 0;       
        for (Item item : items) {
            sum += item.getSum();
            if (item.getMin() < min) {
                min = item.getMin();
            }
            if (max < item.getMax()) {
                max = item.getMax();
            }
            avg += item.getAvg();
        }
        avg = avg / items.size();
        return new Item(null, sum, avg, min, max);
    }

}
