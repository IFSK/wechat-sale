package xyz.oilpea.wechat.agency.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;

public interface OrderSystemService {
	public Agencyorders queryOrderInfoFormA(Integer orderId);
	
	public Headquartersorders queryOrderInfoFormH(Integer orderId);
	
	public List<ConciseOrders> showUntreatedLowerLevelOrder(int agencyId);
	
	public List<ConciseOrders> showProcessedLowerLevelOrder(int agencyId);
	
	public List<ConciseOrders> showMyOrder(int agencyId , int orderState);
	
	public List<Itemstype> showItemTypyList();
	
	public void orderDown(int itemId,int itemCount,int receiveId, String receivePhone, String receiveAddress);
	
	public void createDeliveryOrder(int orderId, int sendId, String sendAddress, String snedPhone);
	
	public void cancelOrder(int orderId,String wechatId);
	
	public void test();
	
	public void test2();
}
