package xyz.oilpea.wechat.agency.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.dao.AgencyDao;
import xyz.oilpea.wechat.agency.mapper.AgencyMapper;
import xyz.oilpea.wechat.agency.mapper.AgencyorderdetailMapper;
import xyz.oilpea.wechat.agency.mapper.AgencyordersMapper;
import xyz.oilpea.wechat.agency.mapper.HeadquartersorderdetailMapper;
import xyz.oilpea.wechat.agency.mapper.HeadquartersordersMapper;
import xyz.oilpea.wechat.agency.mapper.ItemstypeMapper;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorderdetail;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.Headquartersorderdetail;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.service.OrderSystemService;

@Service
public class IOrderSystemService implements OrderSystemService {
	
	@Autowired
	ItemstypeMapper im;
	
	@Autowired
	AgencyDao ad;
	
	@Autowired
	AgencyordersMapper orderMapper;
	
	@Autowired
	AgencyorderdetailMapper orderdetailMapper;
	
	@Autowired
	AgencyMapper am;
	
	@Autowired
	HeadquartersordersMapper hm;
	
	@Autowired
	HeadquartersorderdetailMapper hdm;
	
	@Override
	public Agencyorders queryOrderInfoFormA(Integer orderId) {
		// TODO Auto-generated method stub
		return ad.queryOrdersDetailByOrderIdFromA(orderId);
	}
	
	@Override
	public Headquartersorders queryOrderInfoFormH(Integer orderId) {
		// TODO Auto-generated method stub
		return ad.queryOrdersDetailByOrderIdFromH(orderId);
	}

	@Override
	public List<ConciseOrders> showUntreatedLowerLevelOrder(int agencyId) {
		// TODO Auto-generated method stub
		List<Agencyorders> agencyorders=ad.queryOrdersByLowerLevelIdAndState(ad.queryAgencyById(agencyId).getInvitationCode(), 1);
		List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
		ConciseOrders conciseOrders =null;
		Itemstype it = null;
		for (Agencyorders agencyorder : agencyorders) {
			conciseOrders=new ConciseOrders();
			Agencyorderdetail agencyorderdetail=ad.queryOrdersConciseByOrderIdFromA(agencyorder.getOrderId());
			it=ad.queryItemstypeById(agencyorderdetail.getItemId());
			conciseOrders.setOrderId(agencyorder.getOrderId());
			conciseOrders.setItemName(it.getItemName());
			conciseOrders.setItemHeadImg(it.getItemHeadImg());
			conciseOrders.setItemCount(agencyorderdetail.getItemCount());
			conciseOrdersList.add(conciseOrders);
		}
		return conciseOrdersList;
	}

	@Override
	public List<ConciseOrders> showProcessedLowerLevelOrder(int agencyId) {
		// TODO Auto-generated method stub
		List<Agencyorderdetail> processedOrders=ad.queryOrdersBySendIdAndState(agencyId, 2);
		List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
		ConciseOrders conciseOrders =null;
		Itemstype it = null;
		for (Agencyorderdetail agencyorderdetail : processedOrders) {
			conciseOrders=new ConciseOrders();
			it=ad.queryItemstypeById(agencyorderdetail.getItemId());
			conciseOrders.setOrderId(agencyorderdetail.getOrderId());
			conciseOrders.setItemCount(agencyorderdetail.getItemCount());
			conciseOrders.setItemName(it.getItemName());
			conciseOrders.setItemHeadImg(it.getItemHeadImg());
			conciseOrdersList.add(conciseOrders);
		}
		return conciseOrdersList;
	}

	@Override
	public List<ConciseOrders> showMyOrder(int agencyId , int orderState) {
		// TODO Auto-generated method stub
		Agency agency=ad.queryAgencyById(agencyId);
		List<ConciseOrders> conciseOrdersList=new ArrayList<ConciseOrders>();
		ConciseOrders conciseOrders =new ConciseOrders();
		Itemstype it = new Itemstype();
		System.out.println("level:"+agency.getLevel());
		System.out.println("orderState:"+orderState);
		if(agency.getLevel()==1) {
			List<Headquartersorderdetail> myOrders=ad.queryOrdersByReceiveIdAndStateFromH(agencyId, orderState);
			for (Headquartersorderdetail headquartersorderdetail : myOrders) {
				conciseOrders=new ConciseOrders();
				System.out.println(headquartersorderdetail.getItemId()+"+");
				it=ad.queryItemstypeById(headquartersorderdetail.getItemId());
				System.out.println(it);
				conciseOrders.setOrderId(headquartersorderdetail.getOrderId());
				conciseOrders.setItemCount(headquartersorderdetail.getItemCount());
				conciseOrders.setItemName(it.getItemName());
				conciseOrders.setItemHeadImg(it.getItemHeadImg());
				conciseOrdersList.add(conciseOrders);
			}
		}else {
			List<Agencyorderdetail> myOrders=ad.queryOrdersByReceiveIdAndStateFromA(agencyId, orderState);
			for (Agencyorderdetail agencyorderdetail : myOrders) {
				conciseOrders=new ConciseOrders();
				it=ad.queryItemstypeById(agencyorderdetail.getItemId());
				conciseOrders.setOrderId(agencyorderdetail.getOrderId());
				conciseOrders.setItemCount(agencyorderdetail.getItemCount());
				conciseOrders.setItemName(it.getItemName());
				conciseOrders.setItemHeadImg(it.getItemHeadImg());
				conciseOrdersList.add(conciseOrders);
			}
		}
		return conciseOrdersList;
	}

	@Override
	public List<Itemstype> showItemTypyList() {
		// T<ODO Auto-generated method stub
		return im.selectAll();
	}

	@Override
	public void orderDown(int itemId,int itemCount,int receiveId, String receivePhone, String receiveAddress) {//下订单
		// TODO Auto-generated method stub
//		随机生成orderId
		Integer orderId=null;
		Agency agency=am.selectByPrimaryKey(receiveId);
//		获取createtime
		Date createtime=new Date();
//		设置orderState，下订单的orderState为1
		int orderState=1;
		w:do {
			orderId=(int)(Math.random()*999999999)+100000000;
			System.out.println(orderId);
			System.out.println(1000000000);
			if (orderId<1000000000) {
				if (hm.selectByPrimaryKey(orderId)!=null) {
					continue w;
				}else if (orderMapper.selectByPrimaryKey(orderId)!=null) {
					continue w;
				}
				break;
			}
		} while (true);
		if (agency.getLevel()==1) {
			orderState=2;
			Headquartersorders headquartersorders=new Headquartersorders();
			headquartersorders.setOrderId(orderId);
			headquartersorders.setCreatetime(createtime);
			headquartersorders.setOrderState(orderState);
			headquartersorders.setReceiveId(receiveId);
			headquartersorders.setReceiveAddress(receiveAddress);
			headquartersorders.setReceivePhone(receivePhone);
			Headquartersorderdetail headquartersorderdetail=new Headquartersorderdetail();
			headquartersorderdetail.setOrderId(orderId);
			headquartersorderdetail.setItemId(itemId);
			headquartersorderdetail.setItemCount(itemCount);
			hm.insert(headquartersorders);
			hdm.insert(headquartersorderdetail);
		}else {
		Agencyorders agencyorders=new Agencyorders();
		agencyorders.setOrderId(orderId);
		agencyorders.setCreatetime(createtime);
		agencyorders.setOrderState(orderState);
		agencyorders.setReceiveId(receiveId);
		agencyorders.setReceiveAddress(receiveAddress);
		agencyorders.setReceivePhone(receivePhone);
		Agencyorderdetail agencyorderdetail=new Agencyorderdetail();
		agencyorderdetail.setOrderId(orderId);
		agencyorderdetail.setItemId(itemId);
		agencyorderdetail.setItemCount(itemCount);
		orderMapper.insert(agencyorders);
		orderdetailMapper.insert(agencyorderdetail);
		}
	}
	
	@Override
	public void createDeliveryOrder(int orderId, int sendId, String sendAddress, String snedPhone) {
		// TODO Auto-generated method stub
//		设置orderState，出货单的orderState为2
		int orderState=2;
		Agencyorders agencyorders=queryOrderInfoFormA(orderId);
		agencyorders.setOrderState(orderState);
		agencyorders.setSendId(sendId);
		agencyorders.setSendAddress(sendAddress);
		agencyorders.setSnedPhone(snedPhone);
		orderMapper.updateByPrimaryKey(agencyorders);
	}
	
	@Override
	public void cancelOrder(int orderId, String wechatId) {
		// TODO Auto-generated method stub
		if (ad.queryAgencyByWechatId(wechatId).getLevel()==1) {
			hm.deleteByPrimaryKey(orderId);
			hdm.deleteByPrimaryKey(orderId);
		}else {
			orderMapper.deleteByPrimaryKey(orderId);
			orderdetailMapper.deleteByPrimaryKey(orderId);
		}
	}
	
	public void test() {//下订单
//		随机生成orderId
		Integer orderId=null;
//		获取createtime
		Date createtime=new Date();
//		获取itemId
		int itemId=32;
//		获取itemCount
		int itemCount=200;
//		设置orderState，出货单的orderState为1
		int orderState=3;
		int Level=1;
		if (Level==1) {
			List<Headquartersorders> list=hm.selectAll();
			w:do {
				orderId=(int)(Math.random()*999999999)+100000000;
				System.out.println(orderId);
				System.out.println(1000000000);
				if (orderId<1000000000) {
					for (Headquartersorders Headquartersorder : list) {
						if(orderId==Headquartersorder.getOrderId()) {
							continue w;
						}
					}
					break;
				}
			} while (true);
			String receiveAddress="一级经销商";
			String receivePhone="12345678911";
			int receiveId=1;
			Headquartersorders headquartersorders=new Headquartersorders();
			headquartersorders.setOrderId(orderId);
			headquartersorders.setCreatetime(createtime);
			headquartersorders.setOrderState(orderState);
			headquartersorders.setReceiveId(receiveId);
			headquartersorders.setReceiveAddress(receiveAddress);
			headquartersorders.setReceivePhone(receivePhone);
			Headquartersorderdetail headquartersorderdetail=new Headquartersorderdetail();
			headquartersorderdetail.setOrderId(orderId);
			headquartersorderdetail.setItemId(itemId);
			headquartersorderdetail.setItemCount(itemCount);
			hm.insert(headquartersorders);
			hdm.insert(headquartersorderdetail);
		}else {
			List<Agencyorders> list=orderMapper.selectAll();
			w:do {
				orderId=(int)(Math.random()*999999999)+100000000;
				System.out.println(orderId);
				System.out.println(1000000000);
				if (orderId<1000000000) {
					for (Agencyorders agencyorders : list) {
						if(orderId==agencyorders.getOrderId()) {
							continue w;
						}
					}
					break;
				}
			} while (true);
	//		获取receiveId
			int receiveId=2;
	//		获取receiveAddress
			String receiveAddress="二级经销商";
	//		获取receivePhone
			String receivePhone="12345678912";
			Agencyorders agencyorders=new Agencyorders();
			agencyorders.setOrderId(orderId);
			agencyorders.setCreatetime(createtime);
			agencyorders.setOrderState(orderState);
			agencyorders.setReceiveId(receiveId);
			agencyorders.setReceiveAddress(receiveAddress);
			agencyorders.setReceivePhone(receivePhone);
			Agencyorderdetail agencyorderdetail=new Agencyorderdetail();
			agencyorderdetail.setOrderId(orderId);
			agencyorderdetail.setItemId(itemId);
			agencyorderdetail.setItemCount(itemCount);
			orderMapper.insert(agencyorders);
			orderdetailMapper.insert(agencyorderdetail);
		}
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		Integer orderId=365274491;
		Agencyorders record=new Agencyorders();
		record.setOrderId(orderId);
		Agencyorders aOrder =orderMapper.selectOne(record);
//		获取sendId
		int sendId=1;
//		获取sendAddress
		String sendAddress="一级经销商";
//		获取snedPhone
		String snedPhone="12345678911";
//		设置orderState，出货单的orderState为2
		int orderState=2;
		aOrder.setSendId(sendId);
		aOrder.setSendAddress(sendAddress);
		aOrder.setSnedPhone(snedPhone);
		aOrder.setOrderState(orderState);
		orderMapper.updateByPrimaryKey(aOrder);
	}

	


	

	
	
	
	
	
}
