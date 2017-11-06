package producerConsumer.blockingQueue;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;

/**
 * Created by APandey1 on 21-10-2017.
 */
public class Consumer implements Runnable{
    BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed : " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
