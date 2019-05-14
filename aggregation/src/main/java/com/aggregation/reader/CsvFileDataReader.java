/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.reader;

import com.aggregation.model.Item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class CsvFileDataReader implements DataReader {

    private String filePath;
    private String dataSeparator;
    private boolean hasHeaderLine;
    private DateFormat dateFormat;

    public CsvFileDataReader(String filePath, String dataSeparator, boolean hashHeaderLine, DateFormat dateFormat) {
        this.filePath = filePath;
        this.dataSeparator = dataSeparator;
        this.hasHeaderLine = hashHeaderLine;
        this.dateFormat = dateFormat;
    }

    @Override
    public List<Item> readData() {
        try (BufferedReader buff = new BufferedReader(new FileReader(filePath))) {
            List<Item> items = new ArrayList();
            int lineNumber = 0;
            String line = null;
            while ((line = buff.readLine()) != null) {
                if (lineNumber == 0) {
                    lineNumber++;
                    if (hasHeaderLine) {
                        continue;
                    }
                }
                items.add(createItem(line));
            }
            return items;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Item createItem(String line) throws ParseException {
        String[] dataArray = line.split(dataSeparator);
        int i = 0;
        Item item = new Item();
        item.setDate(dateFormat.parse(dataArray[i++]));
        item.setAvg(Double.parseDouble(dataArray[i++]));
        item.setSum(Double.parseDouble(dataArray[i++]));
        item.setMin(Double.parseDouble(dataArray[i++]));
        item.setMax(Double.parseDouble(dataArray[i++]));
        return item;
    }

}
