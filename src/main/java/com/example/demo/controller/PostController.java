package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyd
 * @Description: Post对应返回
 * @date 11:21
 */
@RestController
public class PostController {


	@RequestMapping(value = "doPostTestOne",method = RequestMethod.POST)
	public Object doPostTestOne(User user) {
		return user;
	}


}