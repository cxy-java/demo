package cn.springboot.hadoop;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hive.HiveTemplate;

public class Hive {

	/*@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-hive.xml");
		HiveTemplate hiveTemplate = (HiveTemplate) context.getBean("hiveTemplate");
		List list = hiveTemplate.query("show databases;");
		System.out.println(list);
		list = hiveTemplate.query("select name from mydb.employee;");
		System.out.println(list);
		context.registerShutdownHook();
	}*/

}
