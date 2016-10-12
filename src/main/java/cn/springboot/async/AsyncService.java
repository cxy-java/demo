package cn.springboot.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	private Logger logger = LoggerFactory.getLogger(AsyncService.class);

	public void sayHello() {
		sayHello1();
		sayHello2();
		sayHello3();
	}

	@Async
	public void sayHello1() {
		try {
			new Thread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("say hello1=======");
	}

	@Async
	public void sayHello2() {
		try {
			new Thread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("say hello2=======");
	}

	@Async
	public void sayHello3() {
		try {
			new Thread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("say hello3=======");
	}
}
