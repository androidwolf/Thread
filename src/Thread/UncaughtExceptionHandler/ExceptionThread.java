package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程抛异常不能捕获
 * @author yxx
 */
public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		System.out.println("我准备抛出异常，你能接到吗？");
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		//throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		/*try {
			Thread thread = new Thread(new ExceptionThread());
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(thread);
		} catch (Exception e) {
			System.out.println("我要捉住异常");
			e.printStackTrace();
		}*/
		new Thread(new ExceptionThread()).start();
	}
}
