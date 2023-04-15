import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Worker test = new Worker();
        test.main();
    }


}

class Worker {
    Random random = new Random();
    Object lock1 = new Object();
    Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100));
        }

    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long begin = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - begin));
        System.out.println("list1:" + list1.size());
        System.out.println("list2:" + list2.size());
    }
}
