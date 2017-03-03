package Thread.UncaughtExceptionHandler;

/**
 * 一个抛出异常的线程类 但是想被抓住
 * @author yxx
 */
public class ExceptionThread3 implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run by " + t.getName());
		System.out.println("Exception " + t.getUncaughtExceptionHandler());
		throw new NullPointerException();
	}
	
}
