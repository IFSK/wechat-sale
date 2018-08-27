package xyz.oilpea.wechat.app.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.app.api.mapper.UserMapper;
import xyz.oilpea.wechat.app.api.pojo.User;

@Controller
@RequestMapping("/user")
public class loginController {
	@Autowired
	private UserMapper usermapper;

	@GetMapping("/index")
	public static String login() {
		System.out.println("index");
		return "beetl/IntegralMall.html";
	}

	@GetMapping("/hello")
	public void sayHello() {
		System.out.println("hello");
		User user = new User();
		user.setUserId(1);
		usermapper.select(user);
		System.out.println(user.getScore());
	}

}
