package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yxx
 *
 */
public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new ExceptionThread2());
	}
}
