package Thread.UncaughtExceptionHandler;

/**
 * һ���׳��쳣���߳��� �����뱻ץס
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
