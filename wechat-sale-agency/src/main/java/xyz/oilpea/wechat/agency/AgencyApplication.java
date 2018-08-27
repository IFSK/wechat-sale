package xyz.oilpea.wechat.agency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgencyApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AgencyApplication.class, args);
		System.out.println("agency");
	}

}
