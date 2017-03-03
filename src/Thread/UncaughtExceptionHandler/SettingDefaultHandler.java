package Thread.UncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �����֪����Ҫ�ڴ����д���ʹ����ͬ���쳣����������ô���Ӽ򵥵ķ�ʽ����Thread��������һ����̬��
 * �����������������ΪĬ�ϵ�δ�����쳣�Ĵ�������
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
