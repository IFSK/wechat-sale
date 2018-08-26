package xyz.oilpea.wechat.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("123");
	}

}
