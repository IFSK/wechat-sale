package xyz.oilpea.wechat.agency.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.entity.Example;
import xyz.oilpea.wechat.agency.dao.AgencyDao;
import xyz.oilpea.wechat.agency.mapper.AgencyMapper;
import xyz.oilpea.wechat.agency.mapper.AgencyorderdetailMapper;
import xyz.oilpea.wechat.agency.mapper.AgencyordersMapper;
import xyz.oilpea.wechat.agency.mapper.AgencystockMapper;
import xyz.oilpea.wechat.agency.mapper.HeadquartersorderdetailMapper;
import xyz.oilpea.wechat.agency.mapper.HeadquartersordersMapper;
import xyz.oilpea.wechat.agency.mapper.ItemstypeMapper;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorderdetail;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.Headquartersorderdetail;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;


@Repository
public class IAgencyDao implements AgencyDao {
	
	@Autowired
	AgencystockMapper stockMapper;
	@Autowired
	AgencyMapper mapper;
	@Autowired
	AgencyordersMapper ordersMapper;
	@Autowired
	ItemstypeMapper ItemstypeMapper;
	@Autowired
	AgencyorderdetailMapper orderdetailMapper;
	
	@Autowired
	HeadquartersordersMapper hm;
	
	@Autowired
	HeadquartersorderdetailMapper hdm;

	@Override
	public Agency queryAgencyByWechatId(String wechatId) {//用wechatID查詢Agency
		// TODO Auto-generated method stub
		Agency record=new Agency();
		record.setWechatId(wechatId);
		return mapper.selectOne(record);
	}

	@Override
	public Agency queryAgencyById(int agencyId) {//	用AgencyID查询Agency
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(agencyId);
	}

//	下级
	@Override
	public List<Agency> queryAencyByInvitationCode(String invitationCode) {// 	通过邀请码查看下级	
		// TODO Auto-generated method stub
		String value=invitationCode+".";
		Example example = new Example(Agency.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("invitationCode", value+ "%");
		return mapper.selectByExample(example);
	}

//	订单系统
	@Override
	public List<Agencyorders> queryOrdersByLowerLevelIdAndState(String invitationCode, int orderState) {//未处理的下级订单:orderState=1
		// TODO Auto-generated method stub
//		获取所有下级ID
		List<Agency> agencyList = queryAencyByInvitationCode(invitationCode);
		List<Integer> lowerLevelId=new ArrayList<Integer>();
		int i=0;
		for (Agency agency2 : agencyList) {
			lowerLevelId.add(agency2.getAgencyId());
			lowerLevelId.get(i);
			i++;
		}
//		下级ID作为接受者ID+订单状态获取未处理的下级订单
		List<Agencyorders> agencyordersList = new ArrayList<Agencyorders>();
		Agencyorders agencyorders =new Agencyorders();
		agencyorders.setOrderState(orderState);
		for (Integer ReceiveId : lowerLevelId) {
			agencyorders.setReceiveId(ReceiveId);
			agencyordersList.addAll(ordersMapper.select(agencyorders));
		}
		return agencyordersList;
	}
	
	@Override
	public List<Agencyorderdetail> queryOrdersBySendIdAndState(int sendId, int orderState) {
//		已处理的下级订单(出货单)	:orderState=2	
//		已出货,待接收			:orderState=3
//		已接收					:orderState=4
		// TODO Auto-generated method stub
//		获取OrderId
		Agencyorders record=new Agencyorders();
		record.setSendId(sendId);
		record.setOrderState(orderState);
		List<Agencyorders> list=ordersMapper.select(record);
		List<Agencyorderdetail> agencyorderdetails=new ArrayList<Agencyorderdetail>();
		if (list!=null) {
			List<Integer> integers=new ArrayList<Integer>();
			for (Agencyorders agencyorders : list) {
				System.out.println(agencyorders.getOrderId());
				integers.add(agencyorders.getOrderId());
			}
			Agencyorderdetail agencyorderdetail=new Agencyorderdetail();
			for (Integer integer : integers) {
				System.out.println(integer);
				agencyorderdetail.setOrderId(integer);
				agencyorderdetails.add(orderdetailMapper.selectOne(agencyorderdetail));
			}
		}
		return agencyorderdetails;
	}
	//我的订单ReceiveId=agencyId(我的ID)
	@Override
	public List<Agencyorderdetail> queryOrdersByReceiveIdAndStateFromA(int receiveId, int orderState) {
//		orderState=2:待发货
//		orderState=3:待收货
//		orderState=4:已收货(已入库）
		// TODO Auto-generated method stub
		Agencyorders record=new Agencyorders();
		record.setReceiveId(receiveId);
		record.setOrderState(orderState);
		List<Agencyorders> list=ordersMapper.select(record);
		List<Agencyorderdetail> orderdetails=new ArrayList<Agencyorderdetail>();
		if (list!=null) {
			List<Integer> integers=new ArrayList<Integer>();
			for (Agencyorders orders : list) {
				integers.add(orders.getOrderId());
			}
			Agencyorderdetail orderdetail=new Agencyorderdetail();
			for (Integer integer : integers) {
				orderdetail.setOrderId(integer);
				orderdetails.add(orderdetailMapper.selectOne(orderdetail));
			}
		}
		return orderdetails;
	}
	@Override
	public List<Headquartersorderdetail> queryOrdersByReceiveIdAndStateFromH(int receiveId, int orderState) {
		Headquartersorders record=new Headquartersorders();
		record.setReceiveId(receiveId);
		record.setOrderState(orderState);
		List<Headquartersorders> orders=hm.select(record);
		List<Headquartersorderdetail> orderdetails=new ArrayList<Headquartersorderdetail>();
		if (orders!=null) {
			List<Integer> integers=new ArrayList<Integer>();
			for (Headquartersorders order : orders) {
				integers.add(order.getOrderId());
			}
			Headquartersorderdetail orderdetail=new Headquartersorderdetail();
			for (Integer integer : integers) {
				orderdetail.setOrderId(integer);
				orderdetails.add(hdm.selectOne(orderdetail));
			}
		}
		return orderdetails;
	}
	
	@Override
	public Agencyorders queryOrdersDetailByOrderIdFromA(Integer orderId) {
		// TODO Auto-generated method stub
		Agencyorders record=new Agencyorders();
		record.setOrderId(orderId);
		return ordersMapper.selectOne(record);
	}
	
	@Override
	public Agencyorderdetail queryOrdersConciseByOrderIdFromA(Integer orderId) {
		// TODO Auto-generated method stub
		Agencyorderdetail record=new Agencyorderdetail();
		record.setOrderId(orderId);
		return orderdetailMapper.selectOne(record);
	}
	
	@Override
	public Headquartersorders queryOrdersDetailByOrderIdFromH(Integer orderId) {
		// TODO Auto-generated method stub
		Headquartersorders record=new Headquartersorders();
		record.setOrderId(orderId);
		return hm.selectOne(record);
	}
	
	@Override
	public Headquartersorderdetail queryOrdersConciseByOrderIdFromH(Integer orderId) {
		// TODO Auto-generated method stub
		Headquartersorderdetail record=new Headquartersorderdetail();
		record.setOrderId(orderId);
		return hdm.selectOne(record);
	}
	
//	库存
	@Override
	public List<Agencystock> queryStockByAgencyId(int agencyId) {//	通过经销商ID查询库存
		// TODO Auto-generated method stub
		Agencystock agencystock=new Agencystock();
		agencystock.setAgencyId(agencyId);
		return stockMapper.select(agencystock);
	}
	
	@Override
	public Itemstype queryItemstypeById(Integer itemId) {
		Itemstype it = new Itemstype();
		it.setItemId(itemId);
		// TODO Auto-generated method stub
		return ItemstypeMapper.selectOne(it);
	}
}









