import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Test {
    public static void main(String[] args) {
       int[]arr=new int[10];
       List<Integer> list =new ArrayList<Integer>();

       fillArr(arr);
       fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        arr=Arrays.stream(arr).map(a->a*2).toArray();
        list.stream().map(a->a*2).collect(Collectors.toList());
    }

    private static void fillArr(int[] arr) {
        for (int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
    }
    private static void fillList(List list) {
        for (int i=0; i<10;i++){
            list.add(i+1);
        }
    }

}
