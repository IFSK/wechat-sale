package xyz.oilpea.wechat.agency.service;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.StockInfo;

public interface WarehousingService {
	public List<StockInfo> showListOfStock(Integer agencyId);
	
	public List<Agencystock> queryStock(Integer agencyId,String itemName);
	
	public List<ConciseOrders> showListOfWarehousingOrders(Integer agencyId,Integer orderState);
	
	public List<ConciseOrders> showOrdersDetail(Integer orderId);
	
	public void ConfirmationOfWarehousing(int orderId , String wechatId);
	
}
