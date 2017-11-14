package executor;

import java.util.concurrent.*;

/**
 * Created by APandey1 on 10-11-2017.
 */
public class ScheduledExecutorExample {
    public static void fixedSizeExecutor() throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
        executor.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        fixedSizeExecutor();
    }
}
