package xyz.oilpea.wechat.sale.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"xyz.oilpea.wechat.sale.score.mapper"})
@ComponentScan(basePackages = {"xyz.oilpea"})
@SpringBootApplication
public class ScoreApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(ScoreApplication.class, args);
		System.out.println("ScoreApplication");
	}
}
