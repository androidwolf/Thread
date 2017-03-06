package com.hust.juc;

import java.util.concurrent.CountDownLatch;

/*
 * CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
 */
public class TestCountDownLatch {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(50);
		LatchDemo ld = new LatchDemo(latch);

		long start = System.currentTimeMillis();

		for (int i = 0; i < 50; i++) {
			new Thread(ld, "Thread" + i).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
		}

		long end = System.currentTimeMillis();

		System.out.println("耗费时间为：" + (end - start));
	}

}

class LatchDemo implements Runnable {

	private CountDownLatch latch;
	private volatile int i = 0;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			for (; i < 50; i++) {
				if (i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + "--"
							+ i);
				}
			}
		} finally {
			latch.countDown();
		}

	}

}