package com.hzy.service;

import org.springframework.stereotype.Service;

@Service
public class XmlConfigTestService {
	/**
	 * 启动时观察控制台是否打印信息
	 */
	public XmlConfigTestService(){
		System.out.println("===============================================测试=================================================");
		System.out.println("这条语句测试两个配置:");
		System.out.println("===1.ComponentScan排除了这个文件, 注掉xml-test-bean.xml中的bean,会发现这条语句不会被打印");
		System.out.println("===2.xml文件配置了这个bean,并设置导入了xml配置. 那么这条语句应该被打印");
		System.out.println("===============================================测试=================================================");
	}

}
