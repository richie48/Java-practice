package com.example.demo;

import com.example.demo.servlet.HelloFilter;
import com.example.demo.servlet.HelloListener;
import com.example.demo.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootHelloApplication {

	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean servletBean= new ServletRegistrationBean(new HelloServlet());
		servletBean.addUrlMappings("/helloServlet");
		return servletBean;
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloFilter());
		// Add filter path
		filterBean.addUrlPatterns("/helloServlet");
		return filterBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean listenerBean =
				new ServletListenerRegistrationBean(new HelloListener());
		return listenerBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}

}
