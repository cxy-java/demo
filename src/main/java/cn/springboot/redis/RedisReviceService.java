package cn.springboot.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

/**
 * 接受reids 消息
 * @author changxy
 *
 */
/*@Service
public class RedisReviceService implements MessageListener {

	private Logger logger = LoggerFactory.getLogger(RedisReviceService.class);

	@Override
	public void onMessage(Message message, byte[] pattern) {
		logger.info(message.toString());
	}
}
*/