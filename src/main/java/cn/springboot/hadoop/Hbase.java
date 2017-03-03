package cn.springboot.hadoop;

import java.util.List;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;

public class Hbase {

	/*public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/applicationContext-hbase.xml");
		System.setProperty("hadoop.home.dir", "C:\\Users\\Qutke\\Downloads\\hadoop-common-2.2.0-bin-master");
		HbaseTemplate hbaseTemplate = (HbaseTemplate) context.getBean("hbaseTemplate");

		
		 * hbaseTemplate.execute("MyTable", new TableCallback<Object>() {
		 * 
		 * @Override public Object doInTable(HTableInterface table) throws
		 * Throwable { Put p = new Put(Bytes.toBytes("SomeRow"));
		 * p.add(Bytes.toBytes("SomeColumn"), Bytes.toBytes("SomeQualifier"),
		 * Bytes.toBytes("AValue")); table.put(p); return null; } });
		 
		List<String> rows = hbaseTemplate.find("user", "personal data:name", new RowMapper<String>() {
			@Override
			public String mapRow(Result result, int arg1) throws Exception {
				return result.toString();
			}
		});
		System.out.println("=====" + rows);
		context.registerShutdownHook();
	}*/
}
