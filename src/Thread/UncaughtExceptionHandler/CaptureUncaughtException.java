package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yxx
 * 
 */
public class CaptureUncaughtException {

	public static void main(String[] args) {
		ExecutorService es = Executors
				.newCachedThreadPool(new HandlerThreadFactory());
		es.execute(new ExceptionThread2());
		es.execute(new ExceptionThread3());
	}
}
