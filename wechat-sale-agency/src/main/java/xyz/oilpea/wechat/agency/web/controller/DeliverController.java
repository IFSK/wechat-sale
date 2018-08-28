package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.AgencyService;

@RestController
@RequestMapping("/delivery")
public class DeliverController {

	@Autowired
	AgencyService service;


	@GetMapping()
	public String List() {

		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem.html";
	}

	@GetMapping("/fillCode")
	public String fillCode() {
		return "beetl/deliverySystem/fillInCode.html";
	}
}
