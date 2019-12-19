/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.stream.app02.streamcreation.sub01;

import com.sun.org.apache.xpath.internal.objects.XObject;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;
import java.io.Closeable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.xml.transform.TransformerException;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) {
        //1. Collection
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();

        //2. of
        Stream<String> stream2 = Stream.of("a", "b", "c");
        Stream stream3 = Stream.of("a", "b", "c");
        //Stream<String> stream4 = Stream.of("a",1,"c");
        Stream stream5 = Stream.of("a", 1, "c");

        //3. empty
        Stream<String> stream6 = Stream.empty();
        Stream stream7 = Stream.empty();
        Stream<String> stream8 = Stream.<String>empty();
        Stream<Integer> stream9 = Stream.empty();
        Stream<Integer> stream10 = Stream.<Integer>empty();
        Stream stream11 = Stream.<String>empty();
        Stream stream12 = Stream.<Integer>empty();

        
        
        //4. generate infinty loop
        Stream<String> stream13 = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                String res = "Res" + System.currentTimeMillis();
                System.out.println(res);
                return res;
            }
        });
        //System.out.println(stream13.count());
        
        Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Stream<String> stream14 = Stream.generate(()->"Res2"+System.currentTimeMillis());
        /* In loop - > tends to throw Stream is already closed
        for(int i=0;i<10;i++){
            stream14.findAny().ifPresent(System.out::println);
        }*/
        
        //Math.random()
        Stream<Double> stream15 = Stream.generate(Math::random);
        
        Closeable cl = null;
        
        //5. Iterate          
        Stream<BigInteger> stream16 = Stream.iterate(BigInteger.ZERO, n->{
            System.out.println("n="+n);
            return n.add(BigInteger.ONE);});
        //stream16.findAny().ifPresent(System.out::println);
        //System.out.println(stream16.count());        
    }

}
