/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daterangepicker.impl.stream;

import com.daterangepicker.common.DateRange;
import com.daterangepicker.common.RangeSearcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author prokopiukd
 */
public class RangeSearcherStreamImpl implements RangeSearcher {

    @Override
    public List<DateRange> findDateRanges(Map<String, List<DateRange>> data) {

        Set<Date> dates = data.values().stream().flatMap(t -> {
            Set<Date> dates1 = new TreeSet();
            t.forEach((item) -> {
                dates1.add(item.getStartDate());
                dates1.add(item.getEndDate());
            });
            return dates1.stream();
        }).collect(Collectors.toCollection(TreeSet::new));

        List<DateRange> resultList = new ArrayList();
        Date start = null;
        for (Date date : dates) {
            if (start == null) {
                start = date;
            } else {
                resultList.add(new DateRange(start, date));
                start = date;
            }
        }
        return resultList;
    }

}
