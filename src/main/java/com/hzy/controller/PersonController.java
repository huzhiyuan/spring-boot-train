package com.hzy.controller;

import com.hzy.dao.PersonRepository;
import com.hzy.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 在 控制器(@Controller) 中的一个方法 的返回值的字符串(视图名),
 * 会根据BeanNameViewResolver去查找Bean的名称为返回字符串的View来渲染视图
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping("/save")
	public Person save(String name,String address,Integer age) {
		Person person = personRepository.save(new Person(null, name, age, address));
		return person;
	}

	@RequestMapping("/q1")
	public List<Person> q1(String address) {
		List<Person> people = personRepository.findByAddress(address);
		return people;
	}

	@RequestMapping("/q2")
	public Person q2(String name, String address) {
		Person people = personRepository.findByNameAndAddress(name, address);
		return people;
	}

	@RequestMapping("/q3")
	public Person q3(String name, String address) {
		Person person = personRepository.withNameAndAddressQuery(name, address);
		return person;
	}

	@RequestMapping("/q4")
	public Person q4(String name, String address) {
		Person person = personRepository.withNameAndAddressNamedQuery(name, address);
		return person;
	}
	@RequestMapping("/sort")
	public List<Person> sort() {
		List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
		return people;
	}
	@RequestMapping("/page")
	public Page<Person> page(int page, int size){
		Page<Person> all = personRepository.findAll(new PageRequest(page, size));
		return all;
	}
	@RequestMapping("/all")
	public List<Person> all(){
		return personRepository.findAll();
	}
}
