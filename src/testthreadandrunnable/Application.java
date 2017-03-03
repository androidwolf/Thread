package testthreadandrunnable;

public class Application {

	public static void main(String[] args) {
		
		//继承Thread来实现多线程
		/*MyThread mt1= new MyThread("一号窗口");  
        MyThread mt2= new MyThread("二号窗口");  
        MyThread mt3= new MyThread("三号窗口");  
        mt1.start();  
        mt2.start();  
        mt3.start();*/
        
        //实现Runnable接口实现多线程
        MyThreadForRunnable mt = new MyThreadForRunnable();  
        Thread t1 = new Thread(mt,"一号窗口");  
        Thread t2 = new Thread(mt,"二号窗口");  
        Thread t3 = new Thread(mt,"三号窗口");  

        t1.start();  
        t2.start();  
        t3.start();  
	}

}
