package Thread.UncaughtExceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * ʵ��UncaughtExceptionHandler�ӿڣ�ץס�׳����쳣
 * @author yxx
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caugth: " + e.toString());
	}

}
