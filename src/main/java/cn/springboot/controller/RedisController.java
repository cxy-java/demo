package cn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springboot.redis.RedisService;

@Controller
@RequestMapping("/")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	
	@RequestMapping("qryreids")
	@ResponseBody
	public String add(){
		redisService.qryRedis();
		return "redis";
	}
	
	@RequestMapping("qryreidslist")
	@ResponseBody
	public String addList(){
		redisService.saveRedis();
		return "list";
	}
	
	@RequestMapping("sendredismessage")
	@ResponseBody
	public String sendMessage(){
		redisService.sendMessage();
		return "message";
	}
}
