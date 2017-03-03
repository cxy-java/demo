package cn.springboot.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MessageController {

	@Autowired
	private Producer producer;
	
	@RequestMapping(value = "/send")
	public void sendMessage(){
		producer.send("hello world");
	}
}
