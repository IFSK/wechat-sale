package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/1")
	public String test1() {
		return "beetl/orderDetail.html";
//		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem.html";
//		return "beetl/deliverySystem/fillInCode.html";
//		return "beetl/index.html";
	}
	
	@GetMapping("/2")
	public String test2() {
		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem.html";
	}
	
	@GetMapping("/3")
	public String test3() {
		return "beetl/deliverySystem/fillInCode.html";
	}
}
