/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.reader;

import com.aggregation.model.Item;
import com.aggregation.utils.Utils;
import java.net.URL;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class CsvFileDataReaderTest {

    @Test
    public void noHeaderTest() {
        String filePath = "/reader/noheader/csv/data.csv";
        URL url = getClass().getResource(filePath);
        String dataSeparator = ";";
        boolean hasHeader = false;
        DataReader dataReader = new CsvFileDataReader(url.getFile(), dataSeparator, hasHeader, Utils.DEFAULT_FORMAT);
        List<Item> actualItems = dataReader.readData();
        List<Item> expectedItems = Utils.initExpectedValues(10, "5/14/2019");
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void headerTest() {
        String filePath = "/reader/header/csv/data.csv";
        URL url = getClass().getResource(filePath);
        String dataSeparator = ";";
        boolean hasHeader = true;
        DataReader dataReader = new CsvFileDataReader(url.getFile(), dataSeparator, hasHeader, Utils.DEFAULT_FORMAT);
        List<Item> actualItems = dataReader.readData();
        List<Item> expectedItems = Utils.initExpectedValues(10, "5/14/2019");
        assertEquals(expectedItems, actualItems);
    }

}
