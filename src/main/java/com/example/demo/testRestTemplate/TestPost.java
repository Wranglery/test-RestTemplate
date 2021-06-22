package com.example.demo.testRestTemplate;

import com.example.demo.pojo.User;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


/**
 * @author lyd
 * @Description: Post请求测试类
 * @date 11:09
 */
public class TestPost {


	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void doPostTestOne() {

		String url = "http://localhost:8080/doPostTestOne";

		// 设置请求的 Content-Type 为 application/x-www-form-urlencoded
		MultiValueMap<String,String> header = new LinkedMultiValueMap<>();
		header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

		/**
		 * 方式一拼接： 将请求参数值以 K=V 方式用 & 拼接，发送请求使用
		 */

		// 设置实体类
		User user = new User();
		user.setName("meimei");
		user.setMotto("娇滴滴");
		user.setAge(11);
		user.setGender("女");
		String userStr = "name=" + user.getName() + "&Motto=" + user.getMotto() + "&age=" + user.getAge() + "&Gender=" + user.getGender();
		HttpEntity<String> request = new HttpEntity<>(userStr, header);

		// RestTemplate设定发送UTF-8编码数据
		restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
		ResponseEntity<User> exchangeResult = restTemplate.exchange(url, HttpMethod.POST, request, User.class);
		System.out.println("返回结果1："+exchangeResult);

		/**
		 * 方式二：将请求参数以键值对形式存储在 MultiValueMap 集合，发送请求时使用
		 */
		MultiValueMap<String,Object> map = new LinkedMultiValueMap();
		map.add("name","titi");
		map.add("age",13);
		map.add("gender","女");
		map.add("motto","猛男");
		HttpEntity<MultiValueMap> request2 = new HttpEntity(map,header);
		// RestTemplate设定发送UTF-8编码数据
		restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
		ResponseEntity<User> exchangeResult2 = restTemplate.exchange(url,HttpMethod.POST, request2, User.class);
		System.out.println("返回结果2："+exchangeResult2);


	}


}