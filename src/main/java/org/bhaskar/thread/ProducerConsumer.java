package org.bhaskar.thread;

import java.util.logging.Logger;

public class ProducerConsumer {
    public static void main(String[] args) {
        Kafka kafka=new Kafka();
        Logger logger = Logger.getLogger("ProducerConsumer");

        int limit=20;
        Thread t1=new Thread(()-> {
            for (int i = 0; i < limit; i++) {
                try {
                    kafka.producer("h"+i);
                } catch (InterruptedException e) {
                    logger.info("producer exception "+e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread t2=new Thread(()-> {
            for (int i = 0; i < limit; i++) {
                try {
                    kafka.consumer();
                } catch (InterruptedException e) {
                    logger.info("consumer exception "+e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Kafka {
    String value;
    boolean hasValue = false;

    public synchronized void producer(String  value) throws InterruptedException {
        if (hasValue) {
            wait();
        }
        this.value = value;
        System.out.println("produced value: " + value);
        hasValue = true;
        notify();
    }

    public synchronized void consumer() throws InterruptedException {
        if (!hasValue) {
            wait();
        }
        System.out.println("consumed value :" + value);
        hasValue = false;
        notify();
    }
}
