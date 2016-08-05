package cn.springboot.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class Producer {

	private KafkaTemplate<Integer, String> template = new Config().kafkaTemplate();

	public void send() {
		ListenableFuture<SendResult<Integer, String>> future = template.send("my-topic", "helloworld");
		template.flush();
		future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				System.out.println("success=============");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("failure=============");
			}
		});
	}
}
