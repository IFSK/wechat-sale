package xyz.oilpea.wechat.agency.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.LowerLevelService;

@Controller
@RequestMapping("/lowerlevel")
public class LowerLevelController {
	@Autowired
	LowerLevelService lls;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("/inquiry")
	public String inquiry() {
		System.out.println("窜货查询");
		return "beetl/lowerLevelManagement/FleeingGoodsInquiry";
	}
	
	@GetMapping()
	public String management(@CookieValue(name="agencyWechatId")String wechatId) {
		System.out.println("下级管理");
		List<Agency> lowerLevelList=lls.LowerLevelConciseinfo(wechatId);
		request.setAttribute("lowerLevelList", lowerLevelList);
		System.out.println("test");
		return "beetl/lowerLevelManagement/LowerLevelManagement";
	}
	
	@GetMapping("/detailedInfo")
	public String detailedInfo(@RequestParam Integer agencyId) {
		System.out.println("下级详细信息");
		Agency detailedInfo=lls.LowerLevelDetailinfo(agencyId);
		request.setAttribute("detailedInfo", detailedInfo);
		return "beetl/lowerLevelManagement/LowerLevelDetailedInformation";
	}
}

