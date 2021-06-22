package com.example.demo.testRestTemplate;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Collections;

/**
 * @author lyd
 * @Description: 上传文件测试类
 * @date 14:17
 */
public class TestFiles {

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testUploadFile() {
		String url = "http://localhost:8080/testUploadFile";

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		String filePath = "D:\\IdeaProjects\\test-RestTemplate\\src\\main\\resources\\verifyImg\\1.png";
		FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
		body.add("file", fileSystemResource);

		MultiValueMap<String,Object> header = new LinkedMultiValueMap<>();
		header.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(MediaType.MULTIPART_FORM_DATA_VALUE));

		HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity(body,header);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

		System.out.println("upload: " + responseEntity);
	}


}