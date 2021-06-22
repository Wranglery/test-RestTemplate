package com.example.demo.pojo;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * @author lyd
 * @Description: 用户实体类
 * @date 11:55
 */
@Data
@Component
public class User {

	private String name;

	private Integer age;

	private String gender;

	private String motto;


}