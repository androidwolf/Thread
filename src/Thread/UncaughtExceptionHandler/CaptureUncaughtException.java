package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 准备创建线程抛出异常，线程外捕获
 * @author yxx
 *
 */
public class CaptureUncaughtException {

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool(new HandlerThreadFactory());
		es.execute(new ExceptionThread2());
		es.execute(new ExceptionThread3());
	}
}
