/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.writer;

import com.aggregation.model.Item;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class CsvFileDataWriter implements DataWriter {

    private String filePath;
    private String dataSeparator;

    public CsvFileDataWriter(String filePath, String dataSeparator) {
        this.filePath = filePath;
        this.dataSeparator = dataSeparator;
    }

    @Override
    public void writeData(List<Item> items) {
        try (PrintStream ps = new PrintStream(filePath)) {
            for (Item item : items) {
                String csvLine = createCSVLine(item);
                writeLine(csvLine, ps);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeLine(String csvLine, PrintStream ps) {
        ps.println(csvLine);
    }

    private String createCSVLine(Item item) {
        return String.format("%s%s%s%s%s%s%s%s%s", item.getDate(), dataSeparator, item.getAvg(), dataSeparator, item.getSum(), dataSeparator, item.getMin(), dataSeparator, item.getMax());
    }

}
