package cn.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProviderHandler implements InvocationHandler {

	private Object target;

	public ProviderHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行");
		method.invoke(target, args);
		return null;
	}

}
