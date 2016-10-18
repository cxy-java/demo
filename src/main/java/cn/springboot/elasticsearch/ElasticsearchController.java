package cn.springboot.elasticsearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springboot.elasticsearch.model.User;

@Controller
@RequestMapping("/")
public class ElasticsearchController {

	@Autowired
	private QueryService queryService;

	@RequestMapping(value = "/create")
	@ResponseBody
	public String create() {
		queryService.index();
		return "index";
	}
	
	@RequestMapping(value = "/qrymatch")
	@ResponseBody
	public List<User> qry() {
		Page<User> page = queryService.qry("乔");
		return page.getContent();
	}
}
