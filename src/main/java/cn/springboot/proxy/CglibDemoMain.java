package cn.springboot.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class CglibDemoMain {

	/*public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CglibDemo.class);
		enhancer.setCallback(new CglibProxy());
		CglibDemo demo = (CglibDemo) enhancer.create();
		demo.run();
	}*/
}
