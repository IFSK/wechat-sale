package xyz.oilpea.wechat.agency.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.service.PersonalCenterService;

@Controller
@RequestMapping("/person")
public class PersonalController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	AgencyService as;
	
	@Autowired
	PersonalCenterService person;

	@GetMapping()
	public String personInfo(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		int agencyId=agency.getAgencyId();
		Agency a=person.personalInfo(agencyId);
		request.setAttribute("agency", a);
		return "/beetl/personalCenter/PersonalInformation";
	}
	
	@GetMapping("/moreInfo")
	public String morePersonInfo(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=person.personalInfo(as.getAgencyByWechatId(wechatId).getAgencyId());
		request.setAttribute("agency", agency);
		return "beetl/personalCenter/MorePersonalInformation";
	}
	
	@GetMapping("/bankCard")
	public String bankCard() {
		return "beetl/personalCenter/bankCard";
	}
	
	@GetMapping("/addBankCard")
	public String addBankCard() {
		return "beetl/personalCenter/addBankCard";
	}
	
	@GetMapping("/editInfo")
	public String EditInfo(@RequestParam(name="value")String value,@RequestParam(name="title")String title) {
		String nav;
		switch (title) {
		case "username":nav="用户名";break;
		case "phone":nav="手机号";break;
		case "email":nav="Email";break;
		case "address":nav="地址";break;
		default:nav="";break;
		}
		request.setAttribute("nav", nav);
		request.setAttribute("values", value);
		return "beetl/personalCenter/EditInfo";
	}
	
	public String successEdit(@RequestParam(name="change")String change,@RequestParam(name="nav")String nav,@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		switch (nav) {
		case "用户名":agency.setUsername(change);break;
		case "手机号":agency.setPhone(change);break;
		case "Email":agency.setEmail(change);break;
		case "地址":agency.setAddress(change);break;
		default:System.out.println("error");;break;
		}
		person.Edit(agency);
		return "/person";
	}
}

























