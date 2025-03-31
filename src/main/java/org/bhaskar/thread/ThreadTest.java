package org.bhaskar.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello");
        TotalEarning totalEarning=new TotalEarning(20);
        Thread t1 =new Thread(() -> {
            try {
                totalEarning.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 =new Thread(() -> {
            try {
                totalEarning.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

    }
}
class TotalEarning {
    int count=1;
    int limit;

    TotalEarning(int limit)
    {
        this.limit=limit;
    }

    public synchronized  void  printOdd() throws InterruptedException {
        while (count<=limit) {
            if (count % 2 != 0) {
                System.out.println("odd printer: " + count);
                count++;
                wait();
            }else {
                wait();
            }
        }
    }
    public synchronized  void  printEven() throws InterruptedException {
        while (count<=limit) {
            if (count % 2 == 0) {
                System.out.println("even printer: " + count);
                count++;
                notify();
            }else {
                wait();
            }
        }
    }
}
