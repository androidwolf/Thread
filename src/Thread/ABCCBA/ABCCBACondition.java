package Thread.ABCCBA;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCCBACondition {

	public static void main(String[] args) {

		final ConditionDemo conditionDemo = new ConditionDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					conditionDemo.loopA(i);
					System.out.println("-----------------");
				}
			}
		}, "A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					conditionDemo.loopB(i);
				}
			}
		}, "B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					conditionDemo.loopC(i);
				}

			}
		}, "C").start();
	}

}

class ConditionDemo {

	private int flag = 3; // 标记

	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	/**
	 * total是总共进行了多少轮
	 * 
	 * @param total
	 */
	public void loopA(int total) {

		lock.lock();

		try {
			// 判断
			if (flag != 1) {
				condition1.await();
			}

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t : "
						+ i + " totla: " + total);
			}

			flag = 3;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * total是总共进行了多少轮
	 * 
	 * @param total
	 */
	public void loopB(int total) {

		lock.lock();

		try {
			// 判断
			if (flag != 2) {
				condition2.await();
			}

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t : "
						+ i + " totla: " + total);
			}

			flag = 1;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * total是总共进行了多少轮
	 * 
	 * @param total
	 */
	public void loopC(int total) {

		lock.lock();

		try {
			// 判断
			if (flag != 3) {
				condition3.await();
			}

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t : "
						+ i + " totla: " + total);
			}

			flag = 2;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
