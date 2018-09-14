package xyz.oilpea.wechat.agency.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.service.OrderSystemService;
import xyz.oilpea.wechat.agency.service.WarehousingService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	WarehousingService ws;
	
	@Autowired
	OrderSystemService oss;
	
	@Autowired
	AgencyService as;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	@GetMapping()
	public String list(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		int agencyId=agency.getAgencyId();
		List<ConciseOrders> untreated=oss.showUntreatedLowerLevelOrder(agencyId);
		List<ConciseOrders> processed=oss.showProcessedLowerLevelOrder(agencyId);
		request.setAttribute("untreatedList", untreated);
		request.setAttribute("processedList", processed);
		return "beetl/orderSystem/Subordinate";
	}
	
	@GetMapping("/fillInfo")
	public String fillInfo(@RequestParam(name="oids")int [] oids) {
		session.setAttribute("orderIds", oids);
		return "beetl/orderSystem/FillInInformation";
	}
	
	@GetMapping("/confirm")
	public String confirmLowerLevelOrders(@SessionAttribute(name="orderIds")int [] orderIds,@RequestParam int sendId,@RequestParam String sendAddress,@RequestParam String snedPhone) {
		for (int orderId : orderIds) {
			System.out.println(orderId);
			oss.createDeliveryOrder(orderId, sendId, sendAddress, snedPhone);
		}
		return "beetl/orderSystem/success_confirm";
	}
	
	@GetMapping("/myList")
	public String myList(@CookieValue(name="agencyWechatId")String wechatId) {
		Agency agency=as.getAgencyByWechatId(wechatId);
		int agencyId=agency.getAgencyId();
		List<ConciseOrders> showMyUnshippedOrders=new ArrayList<ConciseOrders>();
		showMyUnshippedOrders.addAll(oss.showMyOrder(agencyId, 1));
		showMyUnshippedOrders.addAll(oss.showMyOrder(agencyId, 2));
		List<ConciseOrders> showMyUncollectedOrders=oss.showMyOrder(agencyId, 3);
		List<ConciseOrders> showMyReceivedOrders=oss.showMyOrder(agencyId, 4);
		request.setAttribute("myUnshippedOrders", showMyUnshippedOrders);
		request.setAttribute("myUncollectedOrders", showMyUncollectedOrders);
		request.setAttribute("myReceivedOrders", showMyReceivedOrders);
		return "beetl/orderSystem/MyListOfGoodsList";
	}
	
	@GetMapping("cancel")
	public String cancelOrder(@RequestParam(name="msoids")Integer [] orderId, @CookieValue(name="agencyWechatId")String wechatId) {
		for (Integer integer : orderId) {
			oss.cancelOrder(integer, wechatId);
		}
		System.out.println("success?");
		return "beetl/orderSystem/success_CancelOrder";
	}
	
	@GetMapping("warehousing")
	public String warehousingOrder(@RequestParam(name="mcoids")Integer [] orderId, @CookieValue(name="agencyWechatId")String wechatId) {
		for (Integer integer : orderId) {
			ws.ConfirmationOfWarehousing(integer,wechatId);
		}
		System.out.println("success?");
		return "beetl/orderSystem/success_CancelOrder";
	}
	
	@GetMapping("/chooseOne")
	public String chooseOne() {
		List<Itemstype> itemstypes=oss.showItemTypyList();
		request.setAttribute("itemstypes", itemstypes);
		return "beetl/orderSystem/OneProduct";
	}
	
	@GetMapping("/chooseMore")
	public String chooseMore() {
		List<Itemstype> itemstypes=oss.showItemTypyList();
		request.setAttribute("itemstypes", itemstypes);
		return "beetl/orderSystem/MoreProduct";
	}
	
	@GetMapping("/success")
	public String orderDown(@RequestParam int itemId,@RequestParam int itemCount,@RequestParam int receiveId,@RequestParam String receivePhone,@RequestParam String receiveAddress) {
		System.out.println(itemId);
		System.out.println(itemCount);
		System.out.println(receiveId);
		System.out.println(receivePhone);
		System.out.println(receiveAddress);
		oss.orderDown(itemId, itemCount, receiveId, receivePhone, receiveAddress);
		return "beetl/orderSystem/success_OrderDown";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="orderId")int orderId,@RequestParam(name="system")String system,@CookieValue(name="agencyWechatId")String wechatId) {
		System.out.println("orderId:"+orderId); 
		String state=null;
		Agency agency=as.getAgencyByWechatId(wechatId);
		Integer orderState=null;
		if (system.equals("my")||system.equals("stock")) {
			if (agency.getLevel()==1) {
				Headquartersorders headquartersorders=oss.queryOrderInfoFormH(orderId);
				System.out.println(headquartersorders.getOrderState());
				orderState=headquartersorders.getOrderState();
				request.setAttribute("Orders", headquartersorders);
				request.setAttribute("table", "headquartersorders");
			}else {
				Agencyorders agencyorders=oss.queryOrderInfoFormA(orderId);
				System.out.println(agencyorders.getOrderState());
				orderState=agencyorders.getOrderState();
				request.setAttribute("Orders", agencyorders);
				request.setAttribute("table", "agencyorders");
			}
			switch (orderState) {
			case 1:
			case 2:state="待出货";break;
			case 3:
				switch(system) {
				case "stock":state="待入库";break;
				case "my":state="待收货";break;
				}
				break;
			case 4:
				switch(system) {
				case "stock":state="已入库";break;
				case "my":state="已收货";break;
				}
				break;
			default:System.out.println("error");break;
			}
		}else {
			Agencyorders agencyorders=oss.queryOrderInfoFormA(orderId);
			System.out.println(agencyorders.getOrderState());
			switch (agencyorders.getOrderState()) {
			case 1:state="未处理";break;							//未处理的下级订单
			case 2:
				switch(system){
				case "lowerLevel":state="已处理";break;			//已处理的下级订单
				case "delivery":state="出货单";break;			//
				}
				break;
			case 3:state="待收货";break;							//system==delivery
			case 4:state="已收货";break;							//system==delivery
			default:System.out.println("error");break;
			}
			request.setAttribute("Orders", agencyorders);
			request.setAttribute("table", "agencyorders");
		}
		if (system.equals("inquiry")) {
			state="窜货查询";
		}
		request.setAttribute("state", state);
		return "beetl/orderSystem/orderDetail";
	}
}


























