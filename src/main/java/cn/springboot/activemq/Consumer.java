package cn.springboot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String text) {
		System.out.println(text+"========================xxxxx");
	}
	
	@JmsListener(destination = "sample.topic")
	public void receiveTopic(String text) {
		System.out.println(text+"========================yyyy");
	}

}