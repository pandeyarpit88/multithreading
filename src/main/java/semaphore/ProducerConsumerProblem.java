package semaphore;

/**
 * Created by APandey on 08-07-2017.
 */
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Que q = new Que();
    }
}

class Producer implements Runnable {
    Que q;
    Producer(Que q) {
        this.q = q;
    }

    @Override
    public void run() {
        for(int i=0; i< 100; i++)
            q.put(i);
    }
}

class Consumer implements Runnable {
    Que q;
    Consumer(Que q) {
        this.q = q;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++)
            q.get();
    }
}

class Que {
    Integer num = 0;
    public void get() {

    }

    public void put(Integer num) {

    }
}