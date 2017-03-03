package Thread.UncaughtExceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 实现UncaughtExceptionHandler接口，抓住抛出的异常
 * @author yxx
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caugth: " + e.toString());
	}

}
