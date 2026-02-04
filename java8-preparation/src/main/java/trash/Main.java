package trash;

import com.enthu.practice.ch09.datetime.*;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        
        String s = " ";
        String[] argsQ = s.split(",");
        System.out.println("argsQ="+Arrays.toString(argsQ));
        
        
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("1", "2");
        Stream.of(list1, list2).flatMap(x->x.stream()).forEach(x->System.out.println(x));
        
        
        
        
        Book b1 = new Book("a", 5.0);
        Book b2 = new Book("b", 5.0);
        Book b3 = new Book("c", 15.0);
        List<Book> books = Arrays.asList(b1,b2,b3);
        
        books.stream().filter(b->b.getTitle().startsWith("a")).forEach(b->b.setPrice(10));
        books.stream().forEach(b->System.out.println(b.getTitle()+"="+b.getPrice()));
               
        
        
        //Optional.of("A").orElse(other)
        
        List<String> letters = Arrays.asList("a","c","b");
        letters.stream().sorted().mapToDouble(t->1);
        
        //letters.replaceAll(c->c.toUpperCase());
        //letters.forEach(c->System.out.print(c));
        
        
        //Stream.of("a","b","c").collect(Collectors.avjoining()).toUpperCase();
        
        
       IntStream.rangeClosed(0,5).forEach(System.out::println);
        List<Integer> list = Arrays.asList(1,2,3);
        double value = list.stream().filter(t->t>1).mapToDouble(i->i*1.0).average().getAsDouble();
        //System.out.println(value);
        //list.stream().forEach(x->x=x*10);
        //list.forEach(x->x=x*10);
        //list.stream().forEach(x->{System.out.println(x);});
        //list.stream().forEach(i->System.out.println(i));
        Map<Boolean, List<Integer>> map= list.stream().collect(Collectors.partitioningBy(item->item%2==0));
        System.out.println("map="+map);
        
    }
    
    
    private static Optional<String> getGrade(int q1){
        Optional<String> q = Optional.empty();
        if(q1>0){
            q = Optional.of(">");
        }else{
            q = q.of("<=");
        }
        return q;
    }

}
