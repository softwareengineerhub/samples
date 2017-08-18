/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.ch02.join;

import java.util.List;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.CsvReader;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

/**
 *
 * @author prokopiukd
 */
public class Main {
    private static final ExecutionEnvironment ENV = ExecutionEnvironment.getExecutionEnvironment();          
    private static final String PATH = "C:\\Users\\prokopiukd\\Documents\\NetBeansProjects\\flink-pluralsight-course\\src\\main\\resources\\ml-latest-small\\";
    private static final String MOVIES_FILE = "movies.csv";
    private static final String RATING_FILE = "ratings.csv";
        
    public static void main(String[] args) throws Exception {
        
        Main main = new Main();
        DataSet<Tuple3<Long, String, String>> movies = main.createMovie();
        DataSet<Tuple2<Long, Double>> ratings = main.createRating();
        List<Tuple2<String, Double>> result = movies.join(ratings).where(0).equalTo(0).
            with(new JoinFunction<Tuple3<Long, String, String>, Tuple2<Long, Double>, Tuple3<String, String, Double>>() {
            @Override
            public Tuple3<String, String, Double> join(Tuple3<Long, String, String> movie, Tuple2<Long, Double> rating) throws Exception {
                String name = movie.f1;
                String genre = movie.f2.split("\\|")[0];
                Double score = rating.f1;
                return new Tuple3<>(name, genre, score);
            }
        }).groupBy(1).reduceGroup(new GroupReduceFunction<Tuple3<String, String, Double>, Tuple2<String, Double>>() {
            @Override
            public void reduce(Iterable<Tuple3<String, String, Double>> itrbl, Collector<Tuple2<String, Double>> clctr) throws Exception {
                String ganreName = null;
                int count = 0;
                double sum = 0;
                for(Tuple3<String, String, Double> item : itrbl){                    
                    ganreName = item.f1;
                    count++;
                    sum+=item.f2;
                }
                clctr.collect(new Tuple2<String, Double>(ganreName, sum/count));
            }
        }).collect();
        for(Tuple2<String, Double> item : result){
            System.out.println(item);
        }
    }
    
    
    private DataSet<Tuple3<Long, String, String>> createMovie(){
        return ENV.readCsvFile(PATH+MOVIES_FILE).
                ignoreFirstLine().
                parseQuotedStrings('"').
                ignoreInvalidLines().
                types(Long.class, String.class, String.class);
    }
    
    private DataSet<Tuple2<Long, Double>> createRating(){
        return ENV.readCsvFile(PATH+RATING_FILE).
                ignoreFirstLine().
                parseQuotedStrings('"').
                ignoreInvalidLines().
                types(Long.class, Double.class);
    }

}
