package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class WarehousingController {
	@GetMapping()
	public String warehousing() {
		return "beetl/warehousingManagement/Warehousing.html";
	}
	
	@GetMapping("/orders")
	public String receiptOrder() {
		return "beetl/warehousingManagement/ReceiptOrder.html";
	}
	
	@GetMapping("/success")
	public String success() {
		return "beetl/warehousingManagement/success_Warehousing.html";
	}
}
