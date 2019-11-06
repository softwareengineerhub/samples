package ch02.stream.app02.streamcreation.sub04;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,10).limit(5).forEach(System.out::print);
        System.out.println();
        Stream.of(1,2,3,4,5,6,7,8,9,10).skip(3).limit(5).forEach(System.out::print);
        System.out.println();
        Stream.of(1,2,3,4,5,6,7,8,9,10).limit(5).skip(3).forEach(System.out::print);
        System.out.println();
        Stream s1 = Stream.of(1,2,3,4,5);
        Stream s2 = Stream.of("a","b","c","d","e");
        Stream res = Stream.concat(s1, s2);
        res.forEach(System.out::print);
        System.out.println();
        Stream.of("a","b","c","d","e").peek(item-> System.out.println("Fetching: "+item)).forEach(System.out::println);

        System.out.println("------------------------------------peek----------------------------------------------------");
        System.out.println();
        Stream.iterate(1.0, p->p*2).peek(e-> System.out.println("Fetch: "+e)).limit(20).forEach(System.out::println);

        System.out.println("------------------------------------peek2----------------------------------------------------");
        System.out.println();

        Stream.of(new MyObjectToPeek("a", 1), new MyObjectToPeek("b", 2)).peek(e->{e.setName(e.getName().toUpperCase());}).
                forEach(System.out::println);


    }
}
