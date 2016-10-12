package cn.springboot.mybatis.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = "cn.springboot.mybatis.mapper", sqlSessionFactoryRef = "sqlSessionFactoryBean")
public class MyBatisConfig {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Bean(name="sqlSessionFactoryBean")
	@Primary
	public SqlSessionFactoryBean createSqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(primaryDataSource);// 指定数据源(这个必须有，否则报错)
		// 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		return sqlSessionFactoryBean;
	}

}
