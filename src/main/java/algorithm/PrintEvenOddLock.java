package algorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by APandey1 on 21-10-2017.
 */
public class PrintEvenOddLock {
    public static void main(String[] args) {
        Lock l = new ReentrantLock(true);
        new Even(l, "Even");
        new Odd(l, "Odd");
    }
}

class Even implements Runnable{
    Lock l;
    public Even(Lock l, String name) {
        this.l = l;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while(Shared1.count < 100) {
            l.lock();
            if(Shared1.count%2 == 0)
                System.out.println(Thread.currentThread().getName() + " - " + Shared1.count++);
            l.unlock();
        }
    }
}

class Odd implements Runnable{
    Lock l;
    public Odd(Lock l, String name) {
        this.l = l;
        new Thread(this, name).start();
    }

    public void run() {
        while (Shared1.count < 100) {
            l.lock();
            if (Shared1.count % 2 != 0)
                System.out.println(Thread.currentThread().getName() + " - " + Shared1.count++);
            l.unlock();
        }
    }
}

class Shared1 {
    public static int count=0;
}