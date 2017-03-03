package Thread.join;

public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("before join");
		Thread.currentThread().join();
		System.out.println("after join");

		// �߳�C 
		final Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, "C");

		// �߳�B
		final Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					threadC.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}, "B");

		// �߳�A
		final Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					threadB.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}, "A");

		threadA.start();
		threadB.start();
		threadC.start();
	}
}
