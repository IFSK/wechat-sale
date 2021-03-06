package xyz.oilpea.wechat.app.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.app.api.mapper.UserMapper;
import xyz.oilpea.wechat.app.api.pojo.User;
import xyz.oilpea.wechat.app.api.service.UserService;

@Controller
@RequestMapping("/user")
public class loginController {
	@Autowired
	private UserService us;

	@GetMapping("/index")
	public String login() {
		System.out.println("index");
		return "beetl/IntegralMall";
	}

	@GetMapping("/hello")
	public void sayHello() {
		us.test2();
	}

}
