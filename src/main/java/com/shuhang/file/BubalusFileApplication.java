package com.shuhang.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuhang.file.mapper")
public class BubalusFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(BubalusFileApplication.class, args);
	}
}
