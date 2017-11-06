package threadAndRunnable;

/**
 * Created by APandey on 06-04-2017.
 */
public class ThreadUnpredictable {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i< 10; i++) {
					System.out.println(Thread.currentThread().getName() + " => " + i);
				}
			}
		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}
