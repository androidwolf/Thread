package testthreadandrunnable;

public class Application {

	public static void main(String[] args) {
		
		//�̳�Thread��ʵ�ֶ��߳�
		/*MyThread mt1= new MyThread("һ�Ŵ���");  
        MyThread mt2= new MyThread("���Ŵ���");  
        MyThread mt3= new MyThread("���Ŵ���");  
        mt1.start();  
        mt2.start();  
        mt3.start();*/
        
        //ʵ��Runnable�ӿ�ʵ�ֶ��߳�
        MyThreadForRunnable mt = new MyThreadForRunnable();  
        Thread t1 = new Thread(mt,"һ�Ŵ���");  
        Thread t2 = new Thread(mt,"���Ŵ���");  
        Thread t3 = new Thread(mt,"���Ŵ���");  

        t1.start();  
        t2.start();  
        t3.start();  
	}

}
