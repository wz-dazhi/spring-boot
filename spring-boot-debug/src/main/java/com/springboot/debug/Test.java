package com.springboot.debug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @projectName: spring-boot-build
 * @package: com.springboot.debug
 * @className: Test
 * @description:
 * @author: zhi
 * @date: 2021/7/15
 * @version: 1.0
 */
@SpringBootApplication
public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(Test.class, args);
		ConfigurableEnvironment e = c.getEnvironment();
		System.out.println(e.getProperty("spring.application.name"));
	}

}
