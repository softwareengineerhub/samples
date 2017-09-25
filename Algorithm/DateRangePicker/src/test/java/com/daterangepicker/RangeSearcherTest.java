/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daterangepicker;

import com.daterangepicker.impl.collection.RangeSearcherCollectionImpl;
import com.daterangepicker.common.DateRange;
import com.daterangepicker.common.RangeSearcher;
import com.daterangepicker.impl.stream.RangeSearcherStreamImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author prokopiukd
 */
public class RangeSearcherTest {

    private RangeSearcher rangeSearcher;
    private Map<String, List<DateRange>> data;
    private DateFormat dateFormat;
    private List<DateRange> expectedRanges;

    @Before
    public void init() {
        try {
            data = new HashMap();
            List<DateRange> listA = new ArrayList();
            dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            listA.add(new DateRange(dateFormat.parse("10.01.2016"), dateFormat.parse("10.05.2016")));
            listA.add(new DateRange(dateFormat.parse("10.07.2016"), dateFormat.parse("10.11.2016")));
            List<DateRange> listB = new ArrayList();
            listB.add(new DateRange(dateFormat.parse("10.03.2016"), dateFormat.parse("10.06.2016")));
            listB.add(new DateRange(dateFormat.parse("10.08.2016"), dateFormat.parse("10.12.2016")));
            data.put("A", listA);
            data.put("B", listB);

            expectedRanges = new ArrayList();
            expectedRanges.add(new DateRange(dateFormat.parse("10.01.2016"), dateFormat.parse("10.03.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.03.2016"), dateFormat.parse("10.05.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.05.2016"), dateFormat.parse("10.06.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.06.2016"), dateFormat.parse("10.07.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.07.2016"), dateFormat.parse("10.08.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.08.2016"), dateFormat.parse("10.11.2016")));
            expectedRanges.add(new DateRange(dateFormat.parse("10.11.2016"), dateFormat.parse("10.12.2016")));

        } catch (ParseException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void collectionImpl() throws ParseException {
        rangeSearcher = new RangeSearcherCollectionImpl();
        List<DateRange> dateRanges = rangeSearcher.findDateRanges(data);
        assertTrue(dateRanges.size() + "", dateRanges.size() == 7);
        assertEquals(expectedRanges, dateRanges);
    }

    @Test
    public void streamImpl() throws ParseException {
        rangeSearcher = new RangeSearcherStreamImpl();
        List<DateRange> dateRanges = rangeSearcher.findDateRanges(data);
        assertTrue(dateRanges.size() + "", dateRanges.size() == 7);
        assertEquals(expectedRanges, dateRanges);
    }

}
