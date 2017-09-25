/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daterangepicker.common;

import java.util.List;
import java.util.Map;

/**
 *
 * @author prokopiukd
 */
public interface RangeSearcher {

    public List<DateRange> findDateRanges(Map<String, List<DateRange>> data);

}
