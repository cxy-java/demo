package cn.springboot.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springboot.mybatis.mapper.UserMapper;
import cn.springboot.mybatis.mapper2.ConfigMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ConfigMapper configMapper;
	
	public List<Map<String,Object>> qryUser(){
		return userMapper.qryUser();
	}
	
	public List<Map<String,Object>> qryConfig(){
		return configMapper.qryConfig();
	}
}
