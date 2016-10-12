package cn.springboot.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springboot.async.AsyncService;
import cn.springboot.service.BootService;
import cn.springboot.service.SparkBean;

@Controller
@RequestMapping("/")
public class BootController {
	private Logger logger = LoggerFactory.getLogger(BootController.class);

	@Autowired
	private BootService bootService;
	@Autowired
	private SparkBean sparkBean;
	@Autowired
	private AsyncService asyncService;

	/*@RequestMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		bootService.qryAll();
		return "Hello World!";
	}*/

	@RequestMapping(value = "/load")
	@ResponseBody
	public String loadData() {
		sparkBean.loadData();
		return "load";
	}

	@RequestMapping(value = "/qry")
	@ResponseBody
	public String qryData() {
		List<Map<String, Object>> list = sparkBean.qryData();
		System.out.println(list);
		return "qry";
	}

	@RequestMapping(value = "/qry2")
	@ResponseBody
	public String qryData2() {
		List<Map<String, Object>> list = sparkBean.qryData2();
		System.out.println(list);
		return "qry";
	}

	@RequestMapping(value = "/qry3")
	@ResponseBody
	public String qryData3() {
		bootService.qryDurid();
		return "qry";
	}
	
	@RequestMapping(value = "/sayhello")
	@ResponseBody
	public String sayHello(){
		asyncService.sayHello1();
		asyncService.sayHello2();
		asyncService.sayHello3();
		return "hello";
	}
}
