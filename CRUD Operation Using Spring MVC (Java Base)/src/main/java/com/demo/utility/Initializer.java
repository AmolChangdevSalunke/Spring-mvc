package com.demo.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext acp= new AnnotationConfigWebApplicationContext();
		acp.register(AppConfig.class);
		acp.setServletContext(sc);
		ServletRegistration.Dynamic sdy=sc.addServlet("DispatcherServlet", new DispatcherServlet(acp));
		sdy.addMapping("/");
	}

}
