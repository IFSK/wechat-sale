package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery")
public class DeliverController {
	
	@GetMapping()
	public String List() {
		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem.html";
	}
	
	@GetMapping("/fillCode")
	public String fillCode() {
		return "beetl/deliverySystem/fillInCode.html";
	}
}
