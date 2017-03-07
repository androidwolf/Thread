package com.hust.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable {

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();

		FutureTask<Integer> result = new FutureTask<Integer>(td);

		new Thread(result).start();

		try {
			System.out.println(result.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class ThreadDemo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}

}
