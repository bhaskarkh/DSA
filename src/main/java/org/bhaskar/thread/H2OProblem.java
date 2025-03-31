package org.bhaskar.thread;

public class H2OProblem {
    public static void main(String[] args) {
        Elements elements =new Elements();
        int limits=10;
        Thread t1=new Thread(()->{
            for (int i = 0; i < limits; i++) {
                try {
                    elements.produceH("H");
                } catch (InterruptedException e) {
                    System.out.println("h interrupted"+e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < limits; i++) {
                try {
                    elements.produceO("O");
                } catch (InterruptedException e) {
                    System.out.println("o interrupted"+e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
        t1.start();
        t2.start();

    }
}

class Elements{
    int hCount=0;
    int oCount=0;

    public synchronized void produceH(String element) throws InterruptedException {
        if(hCount==2 && oCount==1)
        {
            System.out.println("H2O");
            hCount=0;
            oCount=0;
        }
        if(hCount>2)
        {
            wait();
        }
        hCount+=1;
        notify();

    }
    public synchronized void produceO(String element) throws InterruptedException {
        if(hCount==2 && oCount==1)
        {
            System.out.println("H2O");
            hCount=0;
            oCount=0;
        }
        if (hCount==2 && oCount!=1)
        {
            wait();
        }
        oCount+=1;
        notify();

    }
}
