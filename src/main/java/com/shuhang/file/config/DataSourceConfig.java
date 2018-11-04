/**
 * @author mingfei.z 2018年11月4日 下午8:24:09
 */
package com.shuhang.file.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 自定义数据源
 * 
 * @author mingfei.z 2018年11月4日 下午8:49:56
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DataSourceConfig {

	private String url;
	private String username;
	private String password;
	
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
