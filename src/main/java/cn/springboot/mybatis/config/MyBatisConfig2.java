package cn.springboot.mybatis.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "cn.springboot.mybatis.mapper2", sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MyBatisConfig2 {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;

	@Bean(name = "sqlSessionFactoryBean2")
	public SqlSessionFactoryBean createSqlSessionFactoryBean2() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(secondaryDataSource);// 指定数据源(这个必须有，否则报错)
		return sqlSessionFactoryBean;
	}
}
