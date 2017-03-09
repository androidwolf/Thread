package SynchronizedTwoMethod;

public class SynchronizedChongRuSuo implements Runnable {

	private String name;
	private Boolean flag = false;

	public SynchronizedChongRuSuo(String name) {
		this.name = name;
	}

	public synchronized void get() {
		System.out.println(Thread.currentThread().getId() + "---" + this.name);
		if (this.flag) {
			return;
		}
		this.flag = true;
		this.get();
		System.out.println("-----");
		// new SynchronizedChongRuSuo("B").get();
	}

	public synchronized void set() {
		System.out.println(Thread.currentThread().getId() + "---" + this.name);
		if (this.flag) {
			return;
		}
		SynchronizedChongRuSuo ss = new SynchronizedChongRuSuo("B");
		ss.flag = true; 
		ss.set();
		System.out.println("+++++");
	}

	@Override
	public void run() {
		// get();
		set();
	}

	public static void main(String[] args) {
		SynchronizedChongRuSuo ss = new SynchronizedChongRuSuo("A");
		new Thread(ss).start();
		// new Thread(ss).start();
		// new Thread(ss).start();
	}
}
