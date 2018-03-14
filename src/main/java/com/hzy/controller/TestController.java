package com.hzy.controller;

import com.hzy.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 在 控制器(@Controller) 中的一个方法 的返回值的字符串(视图名),
 * 会根据BeanNameViewResolver去查找Bean的名称为返回字符串的View来渲染视图
 */
@Controller
public class TestController {

	@RequestMapping("/")
	String index(){
		return "index";
	}

	@RequestMapping("/person")
	public String person(Model model){
		Person single = new Person("bob",18);

		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("张三",18);
		Person p2 = new Person("李四",17);
		Person p3 = new Person("王五",16);
		Person p4 = new Person("赵六",15);

		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);

		model.addAttribute("singlePerson",single);
		model.addAttribute("people",people);

		return "index";
	}
}
