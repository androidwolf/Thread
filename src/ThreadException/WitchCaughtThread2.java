package ThreadException;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 同样可以为所有的Thread设置一个默认的UncaughtExceptionHandler，
 * 通过调用Thread.setDefaultUncaughtExceptionHandler
 * (Thread.UncaughtExceptionHandler eh)方法，
 * 这是Thread的一个static方法。
 * @author yxx
 *
 */
public class WitchCaughtThread2 {
	public static void main(String args[]) {
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler2());
		Thread thread = new Thread(new Task());
		thread.start();
	}
}

class ExceptionHandler2 implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("==Exception: " + e.getMessage());
	}
}