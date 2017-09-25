package com.daterangepicker.impl.collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.daterangepicker.common.DateRange;
import com.daterangepicker.common.RangeSearcher;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author prokopiukd
 */
public class RangeSearcherCollectionImpl implements RangeSearcher {

    @Override
    public List<DateRange> findDateRanges(Map<String, List<DateRange>> data) {
        Set<Date> dates = new TreeSet();
        for (String key : data.keySet()) {
            List<DateRange> list = data.get(key);
            for (DateRange dateRange : list) {
                dates.add(dateRange.getStartDate());
                dates.add(dateRange.getEndDate());
            }
        }
        List<DateRange> resultList = new ArrayList();
        DateRange dr = null;
        Date start = null;
        for (Date date : dates) {
            if (start == null) {
                start = date;
            } else {
                dr = new DateRange();
                dr.setStartDate(start);
                dr.setEndDate(date);
                start = date;
                resultList.add(dr);
            }
        }
        return resultList;
    }

}
