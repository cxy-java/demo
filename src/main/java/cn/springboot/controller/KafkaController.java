package cn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class KafkaController {

	@Autowired
	private KafkaTemplate<Integer, String> template;

	@RequestMapping("/sendmessage")
	@ResponseBody
	public String sendMessage(String message) {
		ListenableFuture<SendResult<Integer, String>> future = template.send("my-topic", message);
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
		return "success";
	}
}
