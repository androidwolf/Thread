package ThreadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 只有通过execute提交的任务，才能将它抛出的异常交给UncaughtExceptionHandler，
 * 而通过submit提交的任务，无论是抛出的未检测异常还是已检查异常，都将被认为是任务返回状态
 * 的一部分。如果一个由submit提交的任务由于抛出了异常而结束，那么这个异常将被Future.
 * get封装在ExecutionException中重新抛出。
 * 
 * @author yxx
 * 
 */
public class SubmitCaught {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<?> future = exec.submit(new Task());
		exec.shutdown();
		try {
			future.get();
		} catch (Exception e) {
			System.out.println("==Exception: " + e.getMessage());
		}
	}
}
