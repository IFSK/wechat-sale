package xyz.oilpea.wechat.agency.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.service.impl.IAgencyService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	AgencyService as;
	
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
	
	@GetMapping()
	public List<Agencystock> name() {
		Integer id=1;
		System.out.println("test");
		return as.test(id);
	}
	
	@GetMapping("/testtwo")
	public List<Itemstype> testtwo() {
		Integer id=1;
		System.out.println("test");
		return as.testtwo();
	}
}
