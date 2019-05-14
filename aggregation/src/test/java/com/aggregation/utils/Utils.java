/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.utils;

import com.aggregation.model.Item;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Utils {

    public static DateFormat DEFAULT_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Item initPartitionAggregationItem() {
        try {
            Item item = new Item();
            item.setAvg(4.5);
            item.setMax(9);
            item.setMin(0);
            item.setSum(45);
            return item;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static List<Item> initExpectedValues(int n, String dateValue) {
        try {
            List<Item> items = new ArrayList();
            Item item = null;
            for (int i = 0; i < n; i++) {
                item = new Item();
                item.setDate(DEFAULT_FORMAT.parse(dateValue));
                item.setAvg(i);
                item.setMax(i);
                item.setMin(i);
                item.setSum(i);
                items.add(item);
            }
            return items;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
