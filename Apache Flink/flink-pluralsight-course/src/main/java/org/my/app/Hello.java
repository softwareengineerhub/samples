/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 *
 * @author prokopiukd
 */
public class Hello {

    public static void main(String[] args) {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Integer> ds = env.fromElements(1, 2, 3, 4, 5, 6);
        DataSet<String> result = ds.filter(new FilterFunction<Integer>() {
            @Override
            public boolean filter(Integer t) throws Exception {
                return t % 2 == 0;
            }
        }).map(new MapFunction<Integer, String>() {
            @Override
            public String map(Integer t) throws Exception {
                return "Hello, "+t;
            }
        });
        result.writeAsText("output/path");
    }
    

}
