package cn.springboot.redis;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import cn.springboot.controller.BootController;

@Service
public class RedisService {

	private Logger logger = LoggerFactory.getLogger(BootController.class);

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	/**
	 *  add String
	 */
	public void qryRedis() {
		redisTemplate.opsForValue().set("foo", "bar");
		String value = redisTemplate.opsForValue().get("foo");
		logger.info("value=" + value);
	}

	/**
	 * add list
	 */
	public void saveRedis() {
		listOps.leftPush("key1", "java");
		listOps.leftPush("key1", "php");
		listOps.leftPush("key1", "oracle");
		List value = listOps.range("key1", 0, listOps.size("key1"));
		logger.info("value=" + value);
	}
}
