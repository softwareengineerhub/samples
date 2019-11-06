package ch02.stream.app02.streamcreation.sub05;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {
        Stream<String> words = Stream.of("b","c","a");
        Stream<String> longestFirst =
                words.sorted(Comparator.comparing(String::length).reversed());
    }
}
