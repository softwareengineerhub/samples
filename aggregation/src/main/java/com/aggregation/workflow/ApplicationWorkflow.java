/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.workflow;

import com.aggregation.model.Item;
import com.aggregation.partition.PartitionSplitter;
import com.aggregation.processor.AggregationProcessor;
import com.aggregation.reader.DataReader;
import com.aggregation.writer.DataWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ApplicationWorkflow implements Workflow {

    private DataReader dataReader;
    private PartitionSplitter partitionSplitter;
    private AggregationProcessor aggregationProcessor;
    private DataWriter dataWriter;

    public ApplicationWorkflow(DataReader dataReader, PartitionSplitter partitionSplitter, AggregationProcessor aggregationProcessor, DataWriter dataWriter) {
        this.dataReader = dataReader;
        this.partitionSplitter = partitionSplitter;
        this.aggregationProcessor = aggregationProcessor;
        this.dataWriter = dataWriter;
    }

    @Override
    public void doWorkflow() {
        List<Item> items = dataReader.readData();
        Map<Date, List<Item>> partitionData = partitionSplitter.groupByWeek(items);
        List<Item> aggregatedData = new ArrayList();
        for (Date key : partitionData.keySet()) {
            Item aggregatedItem = aggregationProcessor.process(partitionData.get(key));
            aggregatedData.add(aggregatedItem);
        }
        dataWriter.writeData(aggregatedData);
    }

}
