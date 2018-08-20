package xya.oilpea.wechat.sale.headquarters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "xyz.oilpea.wechat.sale" })
@ComponentScan(basePackages = { "xyz.oilpea.*" })
@SpringBootApplication
public class HeadQuartersApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HeadQuartersApplication.class, args);
	}

}
