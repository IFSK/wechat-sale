package xyz.oilpea.wechat.agency.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.servlet.ServletGroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.AgencyList;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.service.OrderSystemService;

@Controller
@RequestMapping("/test")
public class TestController {
	
//	@Autowired
//	GroupTemplate template;
	
//	@Autowired
//	Template template;
	
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	AgencyService as;
	
	@Autowired
	OrderSystemService oss;
	
	@GetMapping()
	public String test() {
		return "beetl/orderSystem/orderDetail";
	}
	
	@GetMapping("/testtwo")
	public String testtwo() {
		oss.test();
//		oss.test2();
		return "beetl/test";
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/1")
//	public Agency test1() {//用wechatID查詢Agency
//		return as.queryAgencyByWechatId("o97Es1GlC7vFb1ofxKDtrQ_5D8Jc");
//	}
//	
//	@GetMapping("/2")
//	public Agency test2() {//用AgencyID查询Agency
//		return as.queryAgencyById(1);
//	}
//	
//	@GetMapping("/3")
//	public List<Agency> test3() {// 通过邀请码查看下级	
////	public List<Agencystock> test3() {
//		System.out.println("通过邀请码查看下级");
//		return as.queryAencyByInvitationCode("123.1");
//	}
//	
//	@GetMapping("/4")
//	public List<Agencystock> test4() {// 通过AgencyID查询库存	
//		System.out.println("通过AgencyID查询库存	");
//		return as.queryStockByAgencyId(2);
//	}
//	
//	@GetMapping("/5")
//	public List<Agencyorders> test5() {// 通过邀请码和订单状态查询未处理的下级订单
//		System.out.println("通过邀请码和订单状态查询未处理的下级订单");
//		return as.queryOrdersByLowerLevelIdAndState("123.1", 1);
//	}
//	
//	@GetMapping("/6")
//	public List<Agencyorderdetail> test6() {
//		System.out.println("test6");
//		return as.queryOrdersBySendIdAndState(1,1);
//	}
	
	
	

}
