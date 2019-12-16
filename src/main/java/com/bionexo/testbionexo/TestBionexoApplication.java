package com.bionexo.testbionexo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackageClasses = TestBionexoApplication.class)
@EnableSwagger2
public class TestBionexoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBionexoApplication.class, args);
	}

}
