package ThreadException;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 之前介绍了一种主动方法来解决未检测异常。
 * 在Thread ApI中同样提供了UncaughtExceptionHandle，
 * 它能检测出某个由于未捕获的异常而终结的情况。
 * 这两种方法是互补的，通过将二者结合在一起，就能有效地防止线程泄露问题。
 * @author yxx
 *
 */
public class WitchCaughtThread {
	public static void main(String args[]) {
		Thread thread = new Thread(new Task());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}

class ExceptionHandler implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("==Exception: " + e.getMessage());
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		System.out.println(3 / 2);
		System.out.println(3 / 0);
		System.out.println(3 / 1);
	}
}