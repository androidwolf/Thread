package testthreadandrunnable;

public class MyThreadForRunnable implements Runnable {
	private int ticket = 10;
	private boolean flag = true;

	public void run() {
		while (flag) {
			if (this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "ÂôÆ±---->"
						+ (this.ticket--));
			} else {
				flag = false;
			}
		}
	}
}
