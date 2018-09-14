package xyz.oilpea.wechat.agency.service;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;

public interface DeliverySystemService {
	public List<ConciseOrders> showListOfUnshipped(String wechatId);
	
	public List<ConciseOrders> showListOfUncollected(String wechatId);
	
	public List<ConciseOrders> showListOfReceived(String wechatId);
	
	public Agency getAgencyInfo(String wechatId);
}
