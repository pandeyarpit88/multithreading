package algorithm;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by APandey on 08-07-2017.
 */
public class PrintEvenOddSemaphore {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Lock l = new ReentrantLock();
        new PrintEven(sem, "Even Thread");
        new PrintOdd(sem, "Odd Thread");
    }
}

class PrintEven implements Runnable {
    Semaphore semaphore;
    PrintEven(Semaphore sem, String name) {
        semaphore = sem;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while (Shared.count < 100) {
            try {
                semaphore.acquire();
                if(Shared.count % 2 != 0)
                    System.out.println("Printing count from " + Thread.currentThread().getName() + " " + ++Shared.count);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintOdd implements Runnable {
    Semaphore semaphore;
    PrintOdd(Semaphore sem, String name) {
        semaphore = sem;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        while (Shared.count < 100) {
            try {
                semaphore.acquire();
                if(Shared.count % 2 == 0)
                    System.out.println("Printing count from " + Thread.currentThread().getName() + " " + ++Shared.count);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Shared {
    public static Integer count = 0;
}
