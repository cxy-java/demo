package cn.springboot.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SparkBean implements InitializingBean, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JavaSparkContext sparkContext;
	private SQLContext sqlContext;

	@Override
	public void afterPropertiesSet() throws Exception {
		/*SparkConf conf = new SparkConf();
		conf.setMaster("local");
		conf.setAppName("MyApp");

		sparkContext = new JavaSparkContext(conf);
		sqlContext = new SQLContext(sparkContext);*/
	}

	public void loadData() {
		Properties properties = new Properties();
		properties.put("user", "query");
		properties.put("password", "query+1601");
		// 可以循环注册表到内存
		/*DataFrame df = sqlContext.read().jdbc("jdbc:mysql://localhost:3306/mytest?user=root&password=", "t_user",
				properties);
		df.registerTempTable("t_user");
		sqlContext.cacheTable("t_user");*/
		// df.cache();
		DataFrame df = sqlContext.read().jdbc("jdbc:mysql://qkdata1.cltv2qruve9e.rds.cn-north-1.amazonaws.com.cn:3306/QT_Future", "mktData_Future",
				properties);
		df.registerTempTable("mktData_Future");
		sqlContext.cacheTable("mktData_Future");
	}

	public List<Map<String, Object>> qryData() {
		/*
		 * sqlContext.sql("select name from t_user").javaRDD().map(new
		 * Function<Row, String>() { private static final long serialVersionUID
		 * = -4755152957452702937L; public String call(Row row) { return
		 * row.getString(0); } });
		 */
		sqlContext.sql("SELECT date, sum(close) FROM mktData_Future group by date").collectAsList();
		return null;
	}
	
	public List<Map<String, Object>> qryData2() {
		/*
		 * sqlContext.sql("select name from t_user").javaRDD().map(new
		 * Function<Row, String>() { private static final long serialVersionUID
		 * = -4755152957452702937L; public String call(Row row) { return
		 * row.getString(0); } });
		 */
		sqlContext.sql("SELECT * FROM mktData_Future ").collectAsList();
		return null;
	}
}
