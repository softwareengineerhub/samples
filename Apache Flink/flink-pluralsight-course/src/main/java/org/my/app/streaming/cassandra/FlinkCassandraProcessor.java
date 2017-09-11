/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app.streaming.cassandra;

import com.datastax.driver.core.Cluster;
import java.util.List;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.cassandra.CassandraSink;
import org.apache.flink.streaming.connectors.cassandra.ClusterBuilder;

/**
 *
 * @author prokopiukd
 */
public class FlinkCassandraProcessor {

    public static void main(String[] args) throws Exception {
        Helper helper = new Helper();
        List<Person> persons = helper.initData(10);
        
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<Tuple2<String, Integer>> dataStream = see.fromCollection(persons).map(new MapFunction<Person, Tuple2<String, Integer>>() {
            
            @Override
            public Tuple2<String, Integer> map(Person t) throws Exception {
                System.out.println(t);
                return new Tuple2<>(t.getName(), t.getAge());
            }
        });
        
        CassandraSink.addSink(dataStream).setQuery("INSERT INTO flink_stream_cassandra.persons(name, age) VALUES(?,?);").setHost("127.0.0.1").build();
        
        see.execute();

    }

}
