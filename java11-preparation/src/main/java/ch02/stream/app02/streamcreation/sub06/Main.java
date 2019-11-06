package ch02.stream.app02.streamcreation.sub06;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of().min(new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });
    }
}
