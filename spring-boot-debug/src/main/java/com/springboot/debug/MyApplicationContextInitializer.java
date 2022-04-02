package com.springboot.debug;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @projectName: spring-boot-build
 * @package: com.springboot.debug
 * @className: MyApplicationContextInitializer
 * @description:
 * @author: zhi
 * @date: 2022/4/1
 * @version: 1.0
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("调用初始化器---MyApplicationContextInitializer ----initialize" + applicationContext.getClass());
	}

}
