package cn.springboot.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Executer {

	/*public static void main(String[] args) {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
		Producter producter = new Producter(arrayBlockingQueue);
		Customer cusotmer = new Customer(arrayBlockingQueue);
		new Thread(cusotmer).start();
		for(;;){
			try {
				Thread.sleep(2000);
				new Thread(producter).start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
}
