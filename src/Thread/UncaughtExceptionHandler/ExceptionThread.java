package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �����߳����쳣���ܲ���
 * @author yxx
 */
public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		System.out.println("��׼���׳��쳣�����ܽӵ���");
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
			System.out.println("��Ҫ׽ס�쳣");
			e.printStackTrace();
		}*/
		new Thread(new ExceptionThread()).start();
	}
}
