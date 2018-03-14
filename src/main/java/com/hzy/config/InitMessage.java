package com.hzy.config;

import org.springframework.stereotype.Component;

@Component
public class InitMessage {

	public void print(){
		System.out.println("我是启动后的第一条语句...注意浏览器访问路径中的\"saber\"");
		System.out.println("http://localhost:9080/saber/");
	}
}
