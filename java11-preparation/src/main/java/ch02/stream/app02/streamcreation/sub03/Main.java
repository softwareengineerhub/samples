package ch02.stream.app02.streamcreation.sub03;

import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,10).map(new Function<Integer, Object>() {

            @Override
            public Object apply(Integer integer) {
                return integer+"Hello";
            }
        });

        Stream.of("a","b","c").map(item->item.toUpperCase());

        Stream.of("A","B","C").map(String::toUpperCase);


        //flatMap
        Stream.of("A","B","C").map(item-> Stream.of(item, item, item));
        Stream.of("A","B","C").flatMap(new Function<String, Stream<?>>() {
            @Override
            public Stream apply(String s) {
                return Stream.of(s,s,s);
            }
        });
        Stream.of("A","B","C").flatMap(item -> Stream.of(item, item, item));

        //-----------------------------------------------------------------
        Stream.of("A","B","C").map(item-> Stream.of(item, item, item)).
                flatMap(item->Stream.of(item+"q")).
                forEach(System.out::println);
        /*Stream.of("A","B","C").flatMap(new Function<String, Stream<?>>() {
            @Override
            public Stream apply(String s) {
                return Stream.of(s,s,s);
            }
        }).forEach(System.out::println);*/
        //Stream.of("A","B","C").flatMap(item -> Stream.of(item, item, item)).forEach(System.out::println);

    }
}
