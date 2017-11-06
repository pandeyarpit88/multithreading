package producerConsumer.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by APandey1 on 21-10-2017.
 */
public class Producer implements Runnable {

    BlockingQueue queue = null;
    public Producer (BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<50; i++) {
            try {
                System.out.println("Produced item "+i);
                queue.put("item " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
