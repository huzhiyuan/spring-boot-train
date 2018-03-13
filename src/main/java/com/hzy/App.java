package com.hzy;

import com.hzy.service.XmlConfigTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


/*
@SpringBootApplication包含了下面三个配置,
----@SpringBootConfiguration
----@EnableAutoConfiguration : 让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置
----@ComponentScan

Spring Boot会自动扫描@SpringBootApplication所在类的同级包以及下级包中的Bean.
所以建议入口类让在groupId+arctifactID组合的包名下

 */
//@SpringBootApplication是Spring Boot的核心注解
// 具体Spring Boot提供了多少自动配置,可以在Maven:xx:spring-boot-autoconfigure源码下看到


//TODO 我需要用到@ComponentScan下面的Filter. 但是似乎@SpringBootApplication不提供(没找到?)...像下面这种两个注解同时存在,不确定会有什么问题(暂时没发现问题)
//TODO 正式开发的时候, 如果没有定制, 我就用@SpringBootApplication, 如果有定制, 我还是用里面的三个注解吧
@SpringBootApplication() //(exclude = xx.class)  exclude可以用来关闭某个自动配置
@ComponentScan(excludeFilters={
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=XmlConfigTestService.class)})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }
}
