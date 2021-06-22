package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lyd
 * @Description: Get对应接收示例
 * @date 10:38
 */
@RestController
public class GetController {

	@Autowired
	User user;

	@RequestMapping("doGetTestOne")
	public Object doGetTestOne() {
		user.setName("getOne");
		user.setMotto("我命油我不油天");
		user.setAge(12);
		user.setGender("男");
		return user;
	}

	@RequestMapping("doGetTestWayOne")
	public Object doGetTestWayOne(Integer age) {
		user.setName("getOne");
		user.setMotto("我命油我不油天");
		user.setAge(age);
		user.setGender("男");
		return user;
	}


}