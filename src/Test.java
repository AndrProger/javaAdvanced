import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finished");

                Random rand = new Random();
                int random=rand.nextInt(10);
                if(random<5){
                    throw new Exception("Bad");
                }
                return random;
            }
        });
        executor.shutdown();

        try {
            int result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            Throwable ex =e.getCause();
            System.out.println(ex.getMessage());
        }


    }
}