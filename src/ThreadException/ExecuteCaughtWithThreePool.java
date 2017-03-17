package ThreadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果采用线程池通过execute的方法去捕获异常,
 * 这时需要将异常的捕获封装到Runnable或者Callable中
 * @author yxx
 *
 */
public class ExecuteCaughtWithThreePool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ThreadPoolTask());
		exec.shutdown();
	}
}

class ThreadPoolTask implements Runnable {
	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(
				new ExceptionHandler());
		System.out.println(3 / 2);
		System.out.println(3 / 0);
		System.out.println(3 / 1);
	}
}