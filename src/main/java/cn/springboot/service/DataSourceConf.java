package cn.springboot.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConf {

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("druidDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "montetdbDataSource")
	@Qualifier("montetdbDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.montetdb")
	public DataSource montetdbDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "montetdbJdbcTemplate")
	public JdbcTemplate montetdbJdbcTemplate(@Qualifier("montetdbDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
