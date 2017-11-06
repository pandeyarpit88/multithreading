package algorithm;

/**
 * Created by APandey1 on 23-10-2017.
 */
public class PrintEvenOddWaitNotify {
    public static void main(String[] args) {
        Counter c = new Counter();
        new OddPrinter(c, "Odd");
        new EvenPrinter(c, "Even");

    }
}

class EvenPrinter implements Runnable {
    Counter c;
    EvenPrinter (Counter c, String name) {
        this.c = c;
        new Thread(this, name).start();
    }
    @Override
    public void run() {
        while( c.counter < 100) {
            synchronized (c) {
                while(c.counter%2 != 0) {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + c.counter++);
                c.notifyAll();
            }
        }
    }
}

class OddPrinter implements Runnable {
    Counter c;
    OddPrinter(Counter c, String name) {
        this.c = c;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while( c.counter < 100) {
            synchronized (c) {
                while (c.counter % 2 == 0) {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + c.counter++);
                c.notifyAll();
            }
        }
    }
}

class Counter {
    public volatile int counter=0;
}