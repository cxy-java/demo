package cn.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;

public class Recive {

	public void receviceMessage() {
		KafkaMessageListenerContainer<Integer, String> container = new KafkaMessageListenerContainer<Integer, String>(
				new Config().consumerFactory(), new ContainerProperties("my-topic"));
		container.setupMessageListener(new MessageListener<Integer, String>() {
			@Override
			public void onMessage(ConsumerRecord<Integer, String> record) {
				System.out.println(record);
			}
		});
		container.start();
	}
}
