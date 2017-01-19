package com.example.web.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.examples.web.interceptors.PerformanceInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.examples.web"})
@PropertySource("classpath:db.properties")
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	private PerformanceInterceptor performanceInterceptor;
	
	@Value("${oracle.db.user}")
	private String userName;
	@Value("${oracle.db.pwd}")
	private String password;
	@Value("${oracle.db.url}")
	private String dbUrl;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
	  @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        messageSource.setUseCodeAsDefaultMessage(true);
	        return messageSource;
	    }
	  
	    @Bean
	    public LocaleResolver localeResolver() {
	        return new SessionLocaleResolver();
	    }
	    @Bean
	    public HandlerInterceptor localeChangeInterceptor() {
	        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	        localeChangeInterceptor.setParamName("language");
	        return localeChangeInterceptor;
	    }
	    
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	    	registry.addInterceptor(performanceInterceptor);
	        registry.addInterceptor(localeChangeInterceptor());
	      
	    }

		
	    @Bean
	    public TilesConfigurer tilesConfigurer() {
	    	TilesConfigurer tiles=new TilesConfigurer();
	    	tiles.setDefinitions("/WEB-INF/tiles/tiles-definitions.xml");
	        return tiles;
	    }

	    @Bean
	    public TilesViewResolver tilesViewResolver() {
	        TilesViewResolver tilesViewResolver = new TilesViewResolver();
	        tilesViewResolver.setOrder(2);
	        return tilesViewResolver;
	    }
	    
	    
	    @Bean
        public DataSource getDataSource() {
	    	BasicDataSource dataSource=new BasicDataSource();
	    	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    	dataSource.setUsername(userName);
	    	dataSource.setPassword(password);
	    	dataSource.setUrl(dbUrl);
	    	return dataSource;
	    }
	    
	    @Bean 
	    public JdbcTemplate getJdbcTemplate(){
	    	return new JdbcTemplate(getDataSource());
	    }
	    
	    @Bean  
	    public InternalResourceViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
	        resolver.setPrefix("/WEB-INF/view/");  
	        resolver.setSuffix(".jsp");
	        return resolver;  
	    }	
}
