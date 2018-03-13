package com.hzy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:xml-test-bean.xml"})
public class XmlTestConfig {
}
