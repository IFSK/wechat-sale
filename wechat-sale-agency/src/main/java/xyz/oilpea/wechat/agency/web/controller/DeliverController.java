package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.agency.pojo.Agency;
//import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.AgencyService;

@RestController
@RequestMapping("/delivery")
public class DeliverController {

	@Autowired
<<<<<<< HEAD
	AgencyService service;


=======
	AgencyService service; 
	
	
>>>>>>> branch 'master' of https://github.com/IFSK/wechat-sale.git
	@GetMapping()
<<<<<<< HEAD
	public String List() {

=======
	public String List(@RequestParam(name="wechatId")String wechatId) {
		Agency agency=service.queryAgencyByWechatId(wechatId);
>>>>>>> branch 'master' of https://github.com/IFSK/wechat-sale.git
		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem.html";
	}

	@GetMapping("/fillCode")
	public String fillCode() {
		return "beetl/deliverySystem/fillInCode.html";
	}
}
