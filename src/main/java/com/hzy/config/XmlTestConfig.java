package com.hzy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:xml-test-bean.xml"})
public class XmlTestConfig {
	private static Logger logger = LoggerFactory.getLogger(XmlTestConfig.class);

	public void XmlTestConfig(){
		logger.warn("顺便测试下log打印.....");
	}
}
