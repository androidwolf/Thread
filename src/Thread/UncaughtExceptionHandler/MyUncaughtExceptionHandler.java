package Thread.UncaughtExceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * UncaughtExceptionHandler
 * @author yxx
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caugth: " + e.toString());
	}

}
