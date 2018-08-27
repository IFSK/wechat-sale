package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lowerlevel")
public class LowerLevelController {
	
	@GetMapping("/inquiry")
	public String inquiry() {
		return "beetl/lowerLevelManagement/FleeingGoodsInquiry.html";
	}
	
	@GetMapping()
	public String management() {
		return "beetl/lowerLevelManagement/LowerLevelManagement.html";
	}
	
	@GetMapping("/detailedInfo")
	public String detailedInfo() {
		return "beetl/lowerLevelManagement/LowerLevelDetailedInformation.html";
	}
}
