package ThreadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 上面介绍了一种主动方法来解决未检测异常。
 * 其实在Thread ApI中同样提供了UncaughtExceptionHandle，
 * 它能检测出某个由于未捕获的异常而终结的情况。
 * @author yxx
 *
 */
public class ThreadException1 {
	public void threadDeal(Runnable r, Throwable t) {
		System.out.println("==Exception: " + t.getMessage());
	}

	class InitialtiveThread implements Runnable {
		@Override
		public void run() {
			Throwable thrown = null;
			try {
				System.out.println(3 / 2);
				System.out.println(3 / 0);
				System.out.println(3 / 1);
			} catch (Throwable e) {
				thrown = e;
			} finally {
				threadDeal(this, thrown);
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ThreadException1().new InitialtiveThread());
		exec.shutdown();
	}

}