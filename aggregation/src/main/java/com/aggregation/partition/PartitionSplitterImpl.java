/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.partition;

import com.aggregation.model.Item;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public class PartitionSplitterImpl implements PartitionSplitter {

    @Override
    public Map<Date, List<Item>> groupByWeek(List<Item> items) {
        Map<Date, List<Item>> partitionData = new HashMap<>();
        for (Item item : items) {
            Date weekPartition = getWeekOfYear(item.getDate());
            if (partitionData.get(weekPartition) == null) {
                partitionData.put(weekPartition, new ArrayList());
            }
            partitionData.get(weekPartition).add(item);
        }
        return partitionData;
    }

    private Date getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.set(Calendar.DAY_OF_WEEK, 0);
        return calendar.getTime();
    }

}
