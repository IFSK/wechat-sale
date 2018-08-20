package xyz.oilpea.wechat.sale.headquarters.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.sale.core.User;


@RestController
@RequestMapping("/hello")
public class UserController {
	@Autowired
	User user;

	@GetMapping
	public void showSpring() {
		user.sayHello();
	}
}
