package xyz.oilpea.wechat.app.api;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = { "xyz.oilpea.wechat.app.api.mapper" })
@ComponentScan(basePackages = { "xyz.oilpea.wechat" })
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAutoConfiguration
public class ApiApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiApplication.class, args);
	}

}
