package com.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author kiran
 */
@SpringBootApplication
//@ComponentScan
@EnableAutoConfiguration
@EnableWebMvc
@Configuration
public class MrsApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(MrsApplication.class, args);
	}
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    
		String[] staticResourceMappingPath = { "classpath:/static/" };

	    registry.addResourceHandler("/resources/**").addResourceLocations(
	            staticResourceMappingPath);
	}*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
