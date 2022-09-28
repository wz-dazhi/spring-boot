package com.springboot.debug;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @projectName: spring-boot-build
 * @package: com.springboot.debug
 * @className: TestSpringFactorys
 * @description:
 * @author: zhi
 * @date: 2022/9/21
 * @version: 1.0
 */
public class TestSpringFactorys {
	public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";

	private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
//		MultiValueMap<String, String> result = cache.get(classLoader);
//		if (result != null) {
//			return result;
//		}

		try {
			Enumeration<URL> urls = (classLoader != null ?
					classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
					ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
			MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				UrlResource resource = new UrlResource(url);
				Properties properties = PropertiesLoaderUtils.loadProperties(resource);
				for (Map.Entry<?, ?> entry : properties.entrySet()) {
					String factoryTypeName = ((String) entry.getKey()).trim();
					for (String factoryImplementationName : StringUtils.commaDelimitedListToStringArray((String) entry.getValue())) {
						result.add(factoryTypeName, factoryImplementationName.trim());
					}
				}
			}
//			cache.put(classLoader, result);
			return result;
		}
		catch (IOException ex) {
			throw new IllegalArgumentException("Unable to load factories from location [" + FACTORIES_RESOURCE_LOCATION + "]", ex);
		}
	}

	public static void main(String[] args) {
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		loadSpringFactories(classLoader);
	}
}
