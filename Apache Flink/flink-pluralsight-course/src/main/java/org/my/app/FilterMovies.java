/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app;

import java.util.Arrays;
import java.util.HashSet;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple3;

/**
 *
 * @author prokopiukd
 */
public class FilterMovies {
    
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();        
        String PATH="C:\\Users\\prokopiukd\\Documents\\NetBeansProjects\\flink-pluralsight-course\\src\\main\\resources\\ml-latest-small\\";
        DataSet<Tuple3<Long, String, String>> lines = env.readCsvFile(PATH+"movies.csv").ignoreFirstLine().parseQuotedStrings('"').ignoreInvalidLines().types(Long.class, String.class, String.class);
        
        DataSet<Movie> movies = lines.map(new MapFunction<Tuple3<Long, String, String>, Movie>() {
            
            @Override
            public Movie map(Tuple3<Long, String, String> csvLine) throws Exception {
                String movieName = csvLine.f1;
                String[] genres = csvLine.f2.split("\\|");
                
                return new Movie(movieName, new HashSet<String>(Arrays.asList(genres)));
            }
        });
        
        DataSet<Movie> filteredMovies=movies.filter(new FilterFunction<Movie>() {
            @Override
            public boolean filter(Movie t) throws Exception {
                return t.getGenres().contains("Drama");
            }
        });
        
        //filteredMovies.print();
       // System.out.println(filteredMovies.count());
       filteredMovies.writeAsText("filter-output");
       
        env.execute();
    }
    
}
