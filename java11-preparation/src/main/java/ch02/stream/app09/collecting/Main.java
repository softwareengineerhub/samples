package ch02.stream.app09.collecting;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> words = Stream.of("a","b","c","d");
        //non generic
        //Object[] result=words.toArray();
        String[] result = words.toArray(String[]::new);
        System.out.println(Arrays.toString(result));

        System.out.println("-------------------Collectors-------------------");
        List<String> list = Stream.of("a","b","c","d").collect(Collectors.toList());
        Set<String> set = Stream.of("a","b","c","d").collect(Collectors.toSet());

        System.out.println("-------------------Collectors with exactly collection-------------------");
        List<String> list2 = Stream.of("a","b","c","d").collect(Collectors.toCollection(LinkedList::new));
        Set<String> set2 = Stream.of("a","b","c","d").collect(Collectors.toCollection(TreeSet::new));

        System.out.println("-------------------String Collectors-------------------");
        String text = Stream.of("a","b","c","d").collect(Collectors.joining());
        String text2 = Stream.of("a","b","c","d").collect(Collectors.joining(";"));

        System.out.println("-------------------IntSummaryStatistics Collectors-------------------");
        IntSummaryStatistics summaryStatistics = Stream.of("a","b","c","d").collect(Collectors.summarizingInt(new ToIntFunction<Object>() {

            @Override
            public int applyAsInt(Object value) {
                return 0;
            }
        }));

        IntSummaryStatistics summaryStatistics2 = Stream.of("a","b","c","d").collect(Collectors.summarizingInt(item->item.length()));
        summaryStatistics2.getAverage();
        summaryStatistics2.getCount();
        summaryStatistics2.getMax();
        summaryStatistics2.getMin();
        summaryStatistics2.getSum();


    }

}
