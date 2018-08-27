package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@GetMapping()
	public String list() {
		return "beetl/orderSystem/Subordinate.html";
	}
	
	@GetMapping("/myList")
	public String myList() {
		return "beetl/orderSystem/MyListOfGoodsList.html";
	}
	
	@GetMapping("/chooseOne")
	public String chooseOne() {
		return "beetl/orderSystem/OneProduct.html";
	}
	
	@GetMapping("/chooseMore")
	public String chooseMore() {
		return "beetl/orderSystem/MoreProduct.html";
	}
	
	@GetMapping("/fillInfo")
	public String fillInfo() {
		return "beetl/orderSystem/FillInInformation.html";
	}
	
	@GetMapping("/detail")
	public String detail() {
		return "/beetl/orderDetail.html";
	}
}
