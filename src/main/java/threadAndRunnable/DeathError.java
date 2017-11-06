package threadAndRunnable;

/**
 * Created by APandey on 06-04-2017.
 */
public class DeathError {
	public static void main(String[] args) {
		Thread t = new Thread("threadDeath") {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " has started");
					stop();
				} catch (ThreadDeath ex) {
					ex.printStackTrace();
				}
			}
		};
		t.start();
	}
}
