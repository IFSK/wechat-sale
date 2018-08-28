package xyz.oilpea.wechat.agency.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lowerlevel")
public class LowerLevelController {
	
	@GetMapping("/inquiry")
	public String inquiry() {
		System.out.println("窜货查询");
		return "beetl/lowerLevelManagement/FleeingGoodsInquiry.html";
	}
	
	@GetMapping()
	public String management() {
		System.out.println("下级管理");
		
		return "beetl/lowerLevelManagement/LowerLevelManagement.html";
	}
	
	@GetMapping("/detailedInfo")
	public String detailedInfo() {
		System.out.println("下级详细信息");
		return "beetl/lowerLevelManagement/LowerLevelDetailedInformation.html";
	}
}

