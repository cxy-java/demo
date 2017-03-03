package cn.springboot.queue;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{

	private BlockingQueue<String> blockingQueue;
	
	public Customer(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		for(;;){
			try {
				String threadName = blockingQueue.take();
				System.out.println("取出：" + threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("取出失败");
			}
		}
	}
}
