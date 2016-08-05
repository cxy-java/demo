package cn.springboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import cn.springboot.netty.WebSocketFrameHandler;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@Component
public class Lister {

	@KafkaListener(id = "foo", topics = "my-topic", containerFactory = "kafkaListenerContainerFactory")
	public void listen(String data) {
		System.out.println("data=" + data);
		for (Channel channel : WebSocketFrameHandler.channels) {
			channel.writeAndFlush(new TextWebSocketFrame(data));
		}
	}
}
