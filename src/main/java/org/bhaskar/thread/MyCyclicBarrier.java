package org.bhaskar.thread;


import java.util.concurrent.Semaphore;

public class MyCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        SharedElement sharedElement =new SharedElement();
        Runnable oxygenRunnable=()-> System.out.print("O");
        Runnable hydrogenRunnable=()-> System.out.print("H");

        int limit=10;
        Thread[] threads = new Thread[15];


        for (int i = 0; i <limit ; i++) {
            new Thread(()->{
                try {
                    sharedElement.hydrogen(hydrogenRunnable);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        for (int i = 0; i <limit/2 ; i++) {
            new Thread(()->{
                try {
                    sharedElement.oxygen(oxygenRunnable);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
class SharedElement {
    Semaphore hydrogen=new Semaphore(2);
    Semaphore oxygen=new Semaphore(0);
    SharedElement(){

    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

       // System.out.println("comes inside hydrogen");
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(hydrogen.availablePermits()==0)
        {
            oxygen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        //System.out.println("comes inside oxygen");
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        oxygen.acquire();
        releaseOxygen.run();
        hydrogen.release(2);

    }
}
