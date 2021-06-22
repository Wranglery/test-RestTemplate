package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/**
 * @author lyd
 * @Description: 文件测试类访问接口
 * @date 14:18
 */
@RestController
public class FileController {

	@RequestMapping(value = "testUploadFile",method = RequestMethod.POST)
	public String testUploadFile(MultipartRequest request) {
		// Spring MVC 使用 MultipartRequest 接受带文件的 HTTP 请求
		MultipartFile file = request.getFile("file");
		String originalFilename = file.getOriginalFilename();
		return "upload success filename: " + originalFilename;
	}


}