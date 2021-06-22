package com.example.demo.testRestTemplate;

import com.example.demo.pojo.User;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * @author lyd
 * @Description: Get测试
 * @date 10:21
 */
public class TestGet {

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * 简单无参使用
	 */
	@Test
	public void doGetTestOne() {

		String url = "http://localhost:8080/doGetTestOne";

		//方式一：GET 方式获取 JSON 串数据
		String result = restTemplate.getForObject(url, User.class).toString();
		System.out.println("返回结果1：" + result);

		//方式二：GET 方式获取 JSON 数据映射后的 User 实体对象
		User user = restTemplate.getForObject(url, User.class);
		System.out.println("返回结果2：" + user);

		//方式三：GET 方式获取包含 User 实体对象 的响应实体 ResponseEntity 对象,用 getBody() 获取
		ResponseEntity responseEntity = restTemplate.getForEntity(url, User.class);
		System.out.println("返回结果3：" + responseEntity.getBody());

		// 方法四
		//构建请求实体 HttpEntity 对象，用于配置 Header 信息和请求参数
		MultiValueMap header = new LinkedMultiValueMap();//一键多值映射
		header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Object> requestEntity = new HttpEntity<>(header);
		//执行请求获取包含 Product 实体对象 的响应实体 ResponseEntity 对象,用 getBody() 获取
		ResponseEntity exchangeResult = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class);
		System.out.println("状态值:" + exchangeResult.getStatusCode());
		System.out.println("返回结果4:" + exchangeResult.getBody());

	}

	/**
	 * 复杂使用
	 */
	@Test
	public void doGetTestTwo() {

		String url = "http://localhost:8080/doGetTestWayOne?age={age}";

		//方式一：将参数的值存在可变长度参数里，按照顺序进行参数匹配
		ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class, 27);
		System.out.println("返回结果1:" + responseEntity);

		//方式二：将请求参数以键值对形式存储到 Map 集合中，用于请求时URL上的拼接
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("age", 101);
		User user = restTemplate.getForObject(url, User.class, uriVariables);
		System.out.println("返回结果2:" + user);
	}


}


