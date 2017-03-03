package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果你知道将要在代码中处处使用相同的异常处理器，那么更加简单的方式是在Thread类中设置一个静态域，
 * 并将这个处理器设置为默认的未捕获异常的处理器。
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
