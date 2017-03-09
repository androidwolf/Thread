package SynchronizedTwoMethod;

public class TowThreadTwoMethod {
	public static void main(String[] args) {
		final TestTowThreadTwoMethod t1 = new TestTowThreadTwoMethod();
		
		Thread th1 = new Thread("Thread1") {
			@Override
			public void run() {
				try {
					t1.function1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				super.run();
			}
		};

		/*Thread th2 = new Thread("Thread2") {

			@Override
			public void run() {
				try {
					t1.function2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				super.run();
			}
		};
*/
		th1.start();
		//th2.start();
	}
}

class TestTowThreadTwoMethod {
	public synchronized void function1() throws InterruptedException {
		/*Thread.sleep(2000);
		System.out.println("function1");*/
		for (int i = 0; i < 10; i++) {
			System.out.println("function1 -----");
			this.function2();
		}
	}

	public synchronized void function2() throws InterruptedException {
		// Thread.sleep(100);
		System.out.println("funtion2");
	}
}
