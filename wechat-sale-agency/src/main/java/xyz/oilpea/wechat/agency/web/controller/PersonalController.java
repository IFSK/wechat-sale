package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonalController {

	@GetMapping()
	public String personInfo() {
		return "beetl/personalCenter/PersonalInformation.html";
	}
	
	@GetMapping("/moreInfo")
	public String morePersonInfo() {
		return "beetl/personalCenter/MorePersonalInformation.html";
	}
	
	@GetMapping("/bankCard")
	public String bankCard() {
		return "beetl/personalCenter/bankCard.html";
	}
	
	@GetMapping("/addBankCard")
	public String addBankCard() {
		return "beetl/personalCenter/addBankCard.html";
	}
}
