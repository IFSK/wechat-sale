package xyz.oilpea.wechat.sale.headquarters.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping()
	public String jumpindex() {
		return "beetl/index.html";

	}
}
