import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);

        }
    }


}

class Connection {
    private static final Connection conn = new Connection();
    private Semaphore semaphore = new Semaphore(10);
    private int connectionCount = 0;

    private Connection() {

    }

    public static Connection getConnection() {
        return conn;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    public void doWork() throws InterruptedException {
        synchronized (this) {
            connectionCount++;
        }
        Thread.sleep(5000);
        synchronized (this) {
            connectionCount--;
        }
    }
}
