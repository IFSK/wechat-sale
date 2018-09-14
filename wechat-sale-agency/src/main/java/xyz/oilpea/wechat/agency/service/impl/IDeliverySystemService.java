package xyz.oilpea.wechat.agency.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.dao.AgencyDao;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorderdetail;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.service.DeliverySystemService;

@Service
public class IDeliverySystemService implements DeliverySystemService {
	@Autowired
	AgencyDao ad;
	
	

	@Override
	public List<ConciseOrders> showListOfUnshipped(String wechatId) {//出货单：orderState=2
		// TODO Auto-generated method stub
		Agency agency=ad.queryAgencyByWechatId(wechatId);
		List<Agencyorderdetail> deliveryOrders=new ArrayList<Agencyorderdetail>();
		deliveryOrders=ad.queryOrdersBySendIdAndState(agency.getAgencyId(), 2);
		if (deliveryOrders!=null) {
			List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
			ConciseOrders conciseOrders =null;
			Itemstype it = null;
			for (Agencyorderdetail agencyorderdetail : deliveryOrders) {
				conciseOrders=new ConciseOrders();
				it=ad.queryItemstypeById(agencyorderdetail.getItemId());
				conciseOrders.setOrderId(agencyorderdetail.getOrderId());
				conciseOrders.setItemCount(agencyorderdetail.getItemCount());
				conciseOrders.setItemName(it.getItemName());
				conciseOrders.setItemHeadImg(it.getItemHeadImg());
				conciseOrdersList.add(conciseOrders);
			}
			return conciseOrdersList;
		}else {
			return null;
		}
		
	}

	@Override
	public List<ConciseOrders> showListOfUncollected(String wechatId) {//已出货,未接收:orderState=3	
		// TODO Auto-generated method stub
		Agency agency=ad.queryAgencyByWechatId(wechatId);
		List<Agencyorderdetail> uncollectedOrders=new ArrayList<Agencyorderdetail>();
		uncollectedOrders=ad.queryOrdersBySendIdAndState(agency.getAgencyId(), 3);
		List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
		ConciseOrders conciseOrders =null;
		Itemstype ite = null;
		if (uncollectedOrders!=null) {
			for (Agencyorderdetail agencyorderdetail : uncollectedOrders) {
				conciseOrders=new ConciseOrders();
				ite=ad.queryItemstypeById(agencyorderdetail.getItemId());
				conciseOrders.setOrderId(agencyorderdetail.getOrderId());
				conciseOrders.setItemCount(agencyorderdetail.getItemCount());
				conciseOrders.setItemName(ite.getItemName());
				conciseOrders.setItemHeadImg(ite.getItemHeadImg());
				conciseOrdersList.add(conciseOrders);
			}
		}
		return conciseOrdersList;
	}

	@Override
	public List<ConciseOrders> showListOfReceived(String wechatId) {//已接收	:orderState=4
		// TODO Auto-generated method stub
		Agency agency=ad.queryAgencyByWechatId(wechatId);
		List<Agencyorderdetail> receivedOrders=new ArrayList<Agencyorderdetail>();
		receivedOrders=ad.queryOrdersBySendIdAndState(agency.getAgencyId(), 4);
		List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
		ConciseOrders conciseOrders =null;
		Itemstype item = null;
		if (receivedOrders!=null) {
			for (Agencyorderdetail agencyorderdetail : receivedOrders) {
				conciseOrders=new ConciseOrders();
				item=ad.queryItemstypeById(agencyorderdetail.getItemId());
				conciseOrders.setOrderId(agencyorderdetail.getOrderId());
				conciseOrders.setItemCount(agencyorderdetail.getItemCount());
				conciseOrders.setItemName(item.getItemName());
				conciseOrders.setItemHeadImg(item.getItemHeadImg());
				conciseOrdersList.add(conciseOrders);
			}
		}
		return conciseOrdersList;
	}

	@Override
	public Agency getAgencyInfo(String wechatId) {
		return ad.queryAgencyByWechatId(wechatId);
	}
}
