package blockingqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by APandey1 on 09-11-2017.
 */
public class CustomBlockingQueue {

    private List queue = new LinkedList();
    private int limit = 10;

    public CustomBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while(this.queue.size() == 10)
            wait();
        if(this.queue.size() == 0)
            notifyAll();
        this.queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0)
            wait();
        if(this.queue.size() == this.limit)
            notifyAll();
        return this.queue.remove(0);
    }

    public static void main(String[] args) {

    }
}
