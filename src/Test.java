import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ProducersConsumer producersConsumer=new ProducersConsumer();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producersConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producersConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }



}

class ProducersConsumer{
    private Queue<Integer> queue=new LinkedList<>();
    private final int LIMIT=10;
    private final Object lock=new Object();
    public void  produce() throws InterruptedException {
        int value=0;
      while (true) {

          synchronized (lock) {
              System.out.println("start producer");
              while (queue.size() == LIMIT) {
                  System.out.println("producer wait size:"+queue.size());
                  lock.wait();
              }
              queue.offer(value++);
              lock.notify();
          }
      }
    }
    public void consume() throws InterruptedException {
       while (true) {
           while (queue.size() == LIMIT) {
               synchronized (lock) {
                   while (queue.size() == 0) {
                       lock.wait();
                   }
                   int value=queue.poll();
                   System.out.println(value);
                   System.out.println("queue size is "+queue.size());
                   lock.notify();
               }
           }
           Thread.sleep(1000);
       }
    }
}
