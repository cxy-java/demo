package cn.springboot.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BootService {

	private Logger logger = LoggerFactory.getLogger(BootService.class);
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate primaryJdbcTemplate;
	
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("montetdbJdbcTemplate")
	private JdbcTemplate montetdbTemplate;
	
	public void qryTest() {
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from t_config");
		logger.info("result=" + result);
	}
	
	public void qryAll(){
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from dailyData");
		logger.info("result=" + result);
	}
	
	public void qryDurid(){
		List<Map<String, Object>> result = primaryJdbcTemplate.queryForList("select * from t_user");
		logger.info("result=" + result);
	}
}
