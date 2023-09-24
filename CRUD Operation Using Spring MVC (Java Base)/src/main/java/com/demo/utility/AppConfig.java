package com.demo.utility;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo")
public class AppConfig {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setSuffix(".jsp");
		return ivr;
	}
@Bean
	public DriverManagerDataSource dmd() {
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/springmvc08");
		d.setUsername("root");
		d.setPassword("root");
		return d;
	}
@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();
		lsf.setDataSource(dmd());
		Properties p = new Properties();
		p.setProperty("org.hibernate.dialect.MySQL55Dialect", "hibernate.dailect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		lsf.setHibernateProperties(p);
		lsf.setAnnotatedClasses(com.demo.model.Student.class);
		return lsf;
	}
}
