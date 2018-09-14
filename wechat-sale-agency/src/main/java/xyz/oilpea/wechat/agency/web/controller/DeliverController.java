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
import org.springframework.web.bind.annotation.SessionAttribute;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
//import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.DeliverySystemService;

@Controller
@RequestMapping("/delivery")
public class DeliverController {
	@Autowired
	DeliverySystemService dss;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;

	@GetMapping()
	public String List(@CookieValue(name="agencyWechatId")String wechatId) {
		System.out.println("delivery");
		Agency agency=dss.getAgencyInfo(wechatId);
		List<ConciseOrders> Unshipped=dss.showListOfUnshipped(wechatId);
		List<ConciseOrders> Uncollected=dss.showListOfUncollected(wechatId);
		List<ConciseOrders> Received=dss.showListOfReceived(wechatId);
		request.setAttribute("Unshipped", Unshipped);
		request.setAttribute("Uncollected", Uncollected);
		request.setAttribute("Received",Received);
		request.setAttribute("agency", agency);
		return "beetl/deliverySystem/ListOfGoodsList_DeliverySystem";
	}

	@GetMapping("/fillCode")
	public String fillCode(@RequestParam(name="itemId")String itemId) {
		return "beetl/deliverySystem/fillInCode.html";
	}
}



















