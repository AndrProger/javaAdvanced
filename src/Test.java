import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Test {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("hello");
        list.add("goodbye");
        list.add("a");
        list.add("ab");

        Comparator<String> comparator = (String a, String b) ->{
            if(a.length()>b.length()) return 1;
            if(a.length()==b.length()) return 0;
            else  return  -1;
        };
        list.sort(comparator);
        System.out.println(list);
    }

   }
