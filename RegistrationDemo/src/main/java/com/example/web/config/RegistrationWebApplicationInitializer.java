package com.example.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class RegistrationWebApplicationInitializer implements WebApplicationInitializer {
	 private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	public void onStartup(ServletContext servletContext) throws ServletException {
		  registerDispatcherServlet(servletContext);

	}
	
	  private AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses) {
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.register(annotatedClasses);
	        return context;
	    }
	  private void registerDispatcherServlet(ServletContext servletContext) {
	        AnnotationConfigWebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
	                new DispatcherServlet(dispatcherContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	    }
}
