/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daterangepicker.impl.stream;

import com.daterangepicker.common.DateRange;
import com.daterangepicker.common.RangeSearcher;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prokopiukd
 */
public class App {

    private static RangeSearcher rangeSearcher;
    private static Map<String, List<DateRange>> data = new HashMap();
    private static DateFormat dateFormat;

    public static void main(String[] args) throws ParseException {
        rangeSearcher = new RangeSearcherStreamImpl();

        List<DateRange> listA = new ArrayList();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        listA.add(new DateRange(dateFormat.parse("10.01.2016"), dateFormat.parse("10.05.2016")));
        listA.add(new DateRange(dateFormat.parse("10.07.2016"), dateFormat.parse("10.11.2016")));
        List<DateRange> listB = new ArrayList();
        listB.add(new DateRange(dateFormat.parse("10.03.2016"), dateFormat.parse("10.06.2016")));
        listB.add(new DateRange(dateFormat.parse("10.08.2016"), dateFormat.parse("10.12.2016")));
        data.put("A", listA);
        data.put("B", listB);

        rangeSearcher.findDateRanges(data);
    }

}
