package ch02.stream.app08.reduction;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(1,"A", new Object()).reduce(new BinaryOperator<Object>() {

            @Override
            public Object apply(Object o, Object o2) {
                return o.hashCode()+o2.hashCode();
            }
        }).ifPresent(System.out::println);
        System.out.println("-----------------------------------------------");
        Stream.of("a",2, new Object()).reduce((a,b)->a.hashCode()+b.hashCode()).ifPresent(System.out::println);
        System.out.println("-----------------------------------------------");

        Stream.of(1,2,3,4,5,6,7).reduce((a,b)->a+b).ifPresent(System.out::println);
        Stream.of(1,2,3,4,5,6,7).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("-----------------------------------------------");
        Integer result =  Stream.of(1,2,3,4,5,6,7).reduce(0, (a, b)->a+b);//.ifPresent(System.out::println);
        System.out.println(result);
    }
}
