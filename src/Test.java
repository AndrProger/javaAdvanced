import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++) {

            executorService.submit(new Processor(i,countDownLatch));
        }
        executorService.shutdown();


        for (int i=0; i<3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }

}
class Processor implements Runnable {
    private  int i;
    private  CountDownLatch countDownLatch;

    public Processor(int i, CountDownLatch countDownLatch) {
        this.i = i;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + i + "processed");
    }
}