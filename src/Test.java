import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        String str ="hello there hey";
        String[] strArr=str.split(" ");
        System.out.println(Arrays.toString(strArr));

        String b ="hello122342312there31232hey";
        b=b.replaceFirst("\\d+",".");
        // b=b.replaceAll("\\d+",".");
        System.out.println(b);

    }
}