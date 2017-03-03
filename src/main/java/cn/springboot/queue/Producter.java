package cn.springboot.queue;

import java.util.concurrent.BlockingQueue;

public class Producter implements Runnable{

	private BlockingQueue<String> blockingQueue;
	
	public Producter(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put("我生产的" + Thread.currentThread().getName());
			System.out.println("我生产的" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("生产失败");
		}
		
	}
	
}
