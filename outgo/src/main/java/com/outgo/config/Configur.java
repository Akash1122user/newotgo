package com.outgo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.outgo")
public class Configur  extends WebMvcConfigurerAdapter{
	 @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setOrder(2);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");	        
	      
	        return viewResolver;
	 }
	 
	 @Bean
	    public ViewResolver viewResolver2() {
		 ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
	        viewResolver.setOrder(1);
	        viewResolver.setBasename("views");
	        return viewResolver;
	    }
	 
	 @Bean(name = "multipartResolver")
	 public CommonsMultipartResolver createMultipartResolver() {
	     CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	     resolver.setDefaultEncoding("utf-8");
	     return resolver;
	 }
	
	

	 
	 
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 System.out.println(registry);
	        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	    }
	 


}
