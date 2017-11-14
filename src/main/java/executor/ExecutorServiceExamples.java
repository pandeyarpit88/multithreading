package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by APandey1 on 10-11-2017.
 */
public class ExecutorServiceExamples {

    public static void executorCallableExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> callable = () -> {
            return Thread.currentThread().getName();
        };
        Future<String> f = executorService.submit(callable);
        try {
            System.out.println("Callable " + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void executorListCallableExample() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> callable = () -> {
            return Thread.currentThread().getName();
        };
        ArrayList<Callable<String>> list = new ArrayList<>();
        for(int i=0; i<15; i++) {
            list.add(callable);
        }
        List<Future<String>> f = executorService.invokeAll(list);
        try {
            for(Future<String> fs : f)
                System.out.println("Callable " + fs.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void executorRunnableExample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            System.out.println("Runnable " + Thread.currentThread().getName());
        };
        executorService.execute(runnable);
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        executorCallableExample();
        executorRunnableExample();
        executorListCallableExample();
    }
}
