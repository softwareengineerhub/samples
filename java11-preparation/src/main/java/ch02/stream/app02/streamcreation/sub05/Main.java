package ch02.stream.app02.streamcreation.sub05;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        Stream<MyDataObjectB> uniqueData =
                Stream.of(new  MyDataObjectB("a", 1, "Object#1"),
                        new  MyDataObjectB("a", 1, "Object#2"),
                        new  MyDataObjectB("a", 1, "Object#3"),
                        new  MyDataObjectB("a", 1, "Object#4"));
        uniqueData.distinct().peek(item->System.out.println(item.hashCode()+"; "+ item.getMessage())).count();

    }
}
