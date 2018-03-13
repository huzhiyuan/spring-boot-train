package com.hzy.config;

import com.hzy.service.XmlConfigTestService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 这么做的话, 以前要一堆@Value注解的属性, 就能很方便的注入进来了
 *
 */

@Component
@ConfigurationProperties(prefix = "configTest")
@PropertySource("classpath:author.properties")
@DependsOn({"xmlConfigTestService"})  //刚好测试下dependson...加上这句的话, 会先准备好xmlConfigTestService对象.这个跑起来看日志就知道了.
public class ConfigSettingTest {
	private String name;
	private Integer age;

	@PostConstruct //这个注解的方法会在对象创建后调用
	private void testPrint(){
		System.out.println("=======================================测试配置属性映射到类对象属性");
		System.out.println(this.getName());
		System.out.println(this.getAge());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
