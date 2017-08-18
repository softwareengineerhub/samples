/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.ch02.join.optimizing;

import java.util.List;
import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.types.DoubleValue;
import org.apache.flink.types.StringValue;
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
        DataSet<Tuple3<Long, String, String>> movies = ENV.readCsvFile(PATH + MOVIES_FILE).ignoreFirstLine().parseQuotedStrings('"').ignoreInvalidLines().types(Long.class, String.class, String.class);
        DataSet<Tuple2<Long, Double>> rating = ENV.readCsvFile(PATH + RATING_FILE).ignoreFirstLine().parseQuotedStrings('"').ignoreInvalidLines().types(Long.class, Double.class);

        List<Tuple2<StringValue, DoubleValue>> result = movies.join(rating).where(0).equalTo(0).with(new FlatJoinFunction<Tuple3<Long, String, String>, Tuple2<Long, Double>, Tuple3<StringValue, StringValue, DoubleValue>>() {
            
            private StringValue name = new StringValue();
            private StringValue ganre = new StringValue();
            private DoubleValue score = new DoubleValue();
            Tuple3<StringValue, StringValue, DoubleValue> tuple3 = new Tuple3<>(name, ganre, score);
            
            @Override
            public void join(Tuple3<Long, String, String> movie, Tuple2<Long, Double> rating, Collector<Tuple3<StringValue, StringValue, DoubleValue>> clctr) throws Exception {
                double ratingValue = rating.f0;                
                String[] ganres = movie.f2.split("\\|");
                for(String ganreItem : ganres){
                    name.setValue(movie.f1);                
                    ganre.setValue(ganreItem);
                    score.setValue(ratingValue);
                    clctr.collect(tuple3);
                }
            }
        }).groupBy(1).reduceGroup(new GroupReduceFunction<Tuple3<StringValue, StringValue, DoubleValue>, Tuple2<StringValue, DoubleValue>>(){
            
            private StringValue name = new StringValue();
            private DoubleValue avg = new DoubleValue();
            private  Tuple2<StringValue, DoubleValue> tuple2 = new Tuple2<>(name, avg);
            
            
            @Override
            public void reduce(Iterable<Tuple3<StringValue, StringValue, DoubleValue>> itrbl, Collector<Tuple2<StringValue, DoubleValue>> clctr) throws Exception {
                long count = 0;
                double rating = 0.0;
                
                for(Tuple3<StringValue, StringValue, DoubleValue> item: itrbl){
                    name.setValue(item.f1.getValue());
                    rating+=item.f2.getValue();
                    count++;
                }
                avg.setValue(rating/count);
                //Tuple2<String, Double> tuple2 = new Tuple2<>(name, rating/count);
                clctr.collect(tuple2);
            }
            
        }).collect();
        for(Tuple2<StringValue, DoubleValue> item : result){
            System.out.println(item.f0.getValue()+"="+item.f1);
        }
        
    }

}
