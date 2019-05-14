/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.partition;

import com.aggregation.model.Item;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface PartitionSplitter {

    public Map<Date, List<Item>> groupByWeek(List<Item> items);

}
