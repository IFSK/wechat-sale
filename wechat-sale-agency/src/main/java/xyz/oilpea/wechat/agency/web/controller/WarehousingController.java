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
import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.StockInfo;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.service.WarehousingService;

@Controller
@RequestMapping("/stock")
public class WarehousingController {
	
	@Autowired
	WarehousingService ws;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	AgencyService as;
	
	@GetMapping()
	public String showStock(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		int agencyId=agency.getAgencyId();
		List<StockInfo> stocks=ws.showListOfStock(agencyId);
		request.setAttribute("stocks", stocks);
		return "/beetl/warehousingManagement/Warehousing";
	}
	
	@GetMapping("/orders")
	public String receiptOrder(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		int agencyId=agency.getAgencyId();
		List<ConciseOrders> untreateds =ws.showListOfWarehousingOrders(agencyId, 3);
		List<ConciseOrders> processeds =ws.showListOfWarehousingOrders(agencyId, 4);
		request.setAttribute("untreateds", untreateds);
		request.setAttribute("processeds", processeds);
		return "/beetl/warehousingManagement/ReceiptOrder";
	}
	
	@GetMapping("/success")
	public String success(@RequestParam(name="woids")Integer [] orderId , @CookieValue(name="agencyWechatId")String wechatId) {
		for (Integer integer : orderId) {
			ws.ConfirmationOfWarehousing(integer,wechatId);
		}
		System.out.println("success?");
		return "beetl/warehousingManagement/success_Warehousing";
	}
}



















