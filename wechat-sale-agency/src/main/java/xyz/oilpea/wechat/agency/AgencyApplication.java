package xyz.oilpea.wechat.agency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;




@MapperScan(basePackages = { "xyz.oilpea.wechat.agency.mapper" })
@ComponentScan(basePackages = { "xyz.oilpea"})
@SpringBootApplication
public class AgencyApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AgencyApplication.class, args);
		System.out.println("agency");
	}

}
