package com.klxsolutions.worldgdp.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DBConfiguration {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String dbUser;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Value("${spring.datasource.driver-class-name}")
	private String dbDriverClassName;

	@Bean
	public DataSource getDataSource() {
		System.out.println("DB URL: " + dbUrl);
		System.out.println("DB User: " + dbUser);
		System.out.println("DB Password: " + dbPassword);
		System.out.println("DB Driver Class: " + dbDriverClassName);

		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setJdbcUrl(dbUrl);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
		NamedParameterJdbcTemplate namedParamJdbcTemplate =
				new NamedParameterJdbcTemplate(getDataSource());
		return namedParamJdbcTemplate;
	}
}

//package com.klxsolutions.worldgdp.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
//@Configuration
//public class DBConfiguration {
//
//	@Value("${spring.datasource.url}")
//	private String dbUrl;
//
//	@Value("${spring.datasource.username}")
//	private String dbUser;
//
//	@Value("${spring.datasource.password}")
//	private String dbPassword;
//
//	@Value("${spring.datasource.driver-class-name}")
//	private String dbDriverClassName;
//
//	@Bean
//	public DataSource getDataSource() {
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName(dbDriverClassName);
//		dataSource.setJdbcUrl(dbUrl);
//		dataSource.setUsername(dbUser);
//		dataSource.setPassword(dbPassword);
//		return dataSource;
//	}
//
//	@Bean
//	public NamedParameterJdbcTemplate namedParamJdbcTemplate() {
//		NamedParameterJdbcTemplate namedParamJdbcTemplate =
//				new NamedParameterJdbcTemplate(getDataSource());
//		return namedParamJdbcTemplate;
//	}
//}
