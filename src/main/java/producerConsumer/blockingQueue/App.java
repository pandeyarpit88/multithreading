package producerConsumer.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by APandey1 on 21-10-2017.
 */
public class App {
    public static void main(String[] args) {
        BlockingQueue queue=new ArrayBlockingQueue(10);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        new Thread(p).start();
        new Thread(c).start();
    }
}
