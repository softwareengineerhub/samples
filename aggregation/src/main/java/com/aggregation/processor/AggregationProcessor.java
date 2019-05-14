/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.processor;

import com.aggregation.model.Item;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface AggregationProcessor {

    public Item process(List<Item> items);

}
