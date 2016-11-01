package cn.springboot.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method mehod, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("代理起来===");
		Object o1 = methodProxy.invokeSuper(object, args);
		return o1;
	}

}
