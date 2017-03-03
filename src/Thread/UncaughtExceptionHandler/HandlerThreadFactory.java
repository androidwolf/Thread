package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ThreadFactory;

/**
 * 实现ThreadFactory来创建线程，为每一个thread对象都附上一个未捕获异常的处理器
 * @author yxx
 *
 */
public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + "creating new thread");
		Thread t = new Thread(r);
		System.out.println("created" + t);
		//为每一个线程设置异常捕获器
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}

}
