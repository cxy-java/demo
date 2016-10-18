package cn.springboot.thrift.impl;

import org.apache.thrift.TException;

import cn.springboot.thrift.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService.Iface{

	@Override
	public void sayHello() throws TException {
		System.out.println("hello world");
	}

}
