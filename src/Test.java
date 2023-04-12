import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread myThreed = new MyThread();
        myThreed.start();

        Scanner scanner =new Scanner(System.in);
        scanner.nextLine();
        myThreed.shutdown();
    }
}
class MyThread extends Thread{
    private volatile boolean running=true;
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  void shutdown() {
        this.running=false;
    }
}