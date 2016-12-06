package com.reachauto.apigateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;

import filter.CustomFilter;
import filter.GrayTestFilter;
import filter.SimpleFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	
	 @Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }
	 
	 @Bean
	  public CustomFilter customFilter() {
	    return new CustomFilter();
	  }
	 
	 @Bean
	  public GrayTestFilter grayTestFilter() {
	    return new GrayTestFilter();
	  }
	 
//	 @Component
//	  public static class MyCommandLineRunner implements CommandLineRunner {
//	    @Override
//	    public void run(String... args) throws Exception {
//	      MonitoringHelper.initMocks();
//	      FilterLoader.getInstance().setCompiler(new GroovyCompiler());
//	      try {
//	        FilterFileManager.setFilenameFilter(new GroovyFileFilter());
//
//	        String basePath = "e:/workspace/apigateway/src/main/java/filter/";
//
//	        FilterFileManager.init(1, basePath );
//	      } catch (Exception e) {
//	        throw new RuntimeException(e);
//	      }
//	    }
//	  }
//	 
	 
}
