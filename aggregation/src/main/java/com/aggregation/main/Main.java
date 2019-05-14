/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregation.main;

import com.aggregation.partition.PartitionSplitter;
import com.aggregation.partition.PartitionSplitterImpl;
import com.aggregation.processor.AggregationProcessorImpl;
import com.aggregation.reader.CsvFileDataReader;
import com.aggregation.reader.DataReader;
import com.aggregation.writer.CsvFileDataWriter;
import com.aggregation.writer.DataWriter;
import com.aggregation.processor.AggregationProcessor;
import com.aggregation.workflow.ApplicationWorkflow;
import com.aggregation.workflow.Workflow;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("---------------AGGREGATION STARTER---------------------------");
        String readPath = "data.csv";
        String writePath = "aggregated.csv";
        String dataSeparator = ";";
        boolean hasHeaderLine = false;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DataReader dataReader = new CsvFileDataReader(readPath, dataSeparator, hasHeaderLine, dateFormat);
        PartitionSplitter partitionSplitter = new PartitionSplitterImpl();
        AggregationProcessor bp = new AggregationProcessorImpl();
        DataWriter dataWriter = new CsvFileDataWriter(writePath, dataSeparator);
        Workflow workflow = new ApplicationWorkflow(dataReader, partitionSplitter, bp, dataWriter);
        workflow.doWorkflow();
        System.out.println("---------------AGGREGATION FINISHED---------------------------");
    }

}
