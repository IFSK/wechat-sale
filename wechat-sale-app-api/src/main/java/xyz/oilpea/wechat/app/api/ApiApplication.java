package xyz.oilpea.wechat.app.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ComponentScan(basePackages = { "xyz.oilpea.wechat" })
@MapperScan(basePackages = "xyz.oilpea.wechat.app.api.mapper")
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAutoConfiguration
public class ApiApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiApplication.class, args);
	}

}
