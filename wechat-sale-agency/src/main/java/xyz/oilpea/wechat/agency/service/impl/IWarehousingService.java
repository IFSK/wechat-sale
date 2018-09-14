package xyz.oilpea.wechat.agency.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Sockaddr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import xyz.oilpea.wechat.agency.pojo.ConciseOrders;
import xyz.oilpea.wechat.agency.pojo.Headquartersorderdetail;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.pojo.StockInfo;
import xyz.oilpea.wechat.agency.service.OrderSystemService;
import xyz.oilpea.wechat.agency.service.WarehousingService;

@Service
public class IWarehousingService implements WarehousingService {
	@Autowired
	AgencyDao ad;
	
	@Autowired
	AgencyMapper am;
	
	@Autowired
	AgencyordersMapper orderMapper;
	
	@Autowired
	AgencyorderdetailMapper adm;
	
	@Autowired
	AgencystockMapper asm;
	
	@Autowired
	ItemstypeMapper im;
	
	@Autowired
	OrderSystemService oss;
	
	@Autowired
	HeadquartersordersMapper hm;
	
	@Autowired
	HeadquartersorderdetailMapper hdm;

	@Override
	public List<StockInfo> showListOfStock(Integer agencyId) {
		// TODO Auto-generated method stub
		Agencystock agencystock=new Agencystock();
		agencystock.setAgencyId(agencyId);
		List<Agencystock> agencystocks=asm.select(agencystock);
		List<StockInfo> stockInfos=new ArrayList<StockInfo>();
		for (Agencystock agencystock2 : agencystocks) {
			StockInfo stockInfo=new StockInfo();
			Itemstype itemstype=new Itemstype();
			itemstype.setItemId(agencystock2.getItemId());
			itemstype=im.selectOne(itemstype);
			
			stockInfo.setItemHeadImg(itemstype.getItemHeadImg());
			stockInfo.setAgencyId(agencyId);
			stockInfo.setItemId(agencystock2.getItemId());
			stockInfo.setItemName(agencystock2.getItemName());
			stockInfo.setItemPrice(agencystock2.getItemPrice());
			stockInfo.setItemStock(agencystock2.getItemStock());
			stockInfos.add(stockInfo);
		}
		return stockInfos;
	}

	@Override
	public List<Agencystock> queryStock(Integer agencyId,String itemName) {
		// TODO Auto-generated method stub
		Example example = new Example(Agencystock.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("agencyId", agencyId+"");
		criteria.andLike("itemName", itemName);
		return asm.selectByExample(example);
	}

//	orderState=3:待入库
//	orderState=4:已入库
	@Override
	public List<ConciseOrders> showListOfWarehousingOrders(Integer agencyId,Integer orderState) {
		// TODO Auto-generated method stub
		List<ConciseOrders> conciseOrders=new ArrayList<ConciseOrders>();
		
		Itemstype i=new Itemstype();
//	Agencyorderdetail
//		itemId
//		itemCount
//	Itemstype
//		itemName
//		itemHeadImg
		if (am.selectByPrimaryKey(agencyId).getLevel()==1) {
			List<Headquartersorderdetail> headquartersorderdetails=ad.queryOrdersByReceiveIdAndStateFromH(agencyId, orderState);
			if (headquartersorderdetails!=null) {
				for (Headquartersorderdetail headquartersorderdetail : headquartersorderdetails) {
					ConciseOrders co=new ConciseOrders();
					System.out.println(headquartersorderdetail.getItemId() + "headquartersorderdetail");
					i=im.selectByPrimaryKey(headquartersorderdetail.getItemId());
					System.out.println(i.getItemId());
					System.out.println(i.getItemName());
					co.setOrderId(headquartersorderdetail.getOrderId());
					co.setItemCount(headquartersorderdetail.getItemCount());
					co.setItemName(i.getItemName());
					co.setItemHeadImg(i.getItemHeadImg());
					conciseOrders.add(co);
				}
			}
		}else {
//			通过agencyId+orderState获取orderId
			List<Agencyorderdetail> Agencyorderdetails=ad.queryOrdersByReceiveIdAndStateFromA(agencyId, orderState);
			if (Agencyorderdetails!=null) {
				for (Agencyorderdetail Agencyorderdetail : Agencyorderdetails) {
					ConciseOrders co=new ConciseOrders();
					Agencyorderdetail agencyorderdetail = new Agencyorderdetail();
//					通过orderId查询agencyorderdetail获得itemId、itemCount
					agencyorderdetail.setOrderId(Agencyorderdetail.getOrderId());
					agencyorderdetail=adm.selectOne(agencyorderdetail);
					
//					通过itemId查询Itemstype获得itemName、itemHeadImg
					i=im.selectByPrimaryKey(agencyorderdetail.getItemId());
//					将itemId、itemCount、itemName、itemHeadImg存入ConciseOrders
					co.setOrderId(agencyorderdetail.getOrderId());
					co.setItemCount(agencyorderdetail.getItemCount());
					co.setItemName(i.getItemName());
					co.setItemHeadImg(i.getItemHeadImg());
//					将ConciseOrders加入List<ConciseOrders>
					conciseOrders.add(co);
				}
			}
		}
		return conciseOrders;
	}


	@Override
	public List<ConciseOrders> showOrdersDetail(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConfirmationOfWarehousing(int orderId , String wechatId) {//确认入库
//		设置orderState，已入库的orderState为4
		int orderState=4;
		Agencystock stock=null;
		Agency record=new Agency();
		record.setWechatId(wechatId);
		record=am.selectOne(record);
		Agencystock agencystock=new Agencystock();
		agencystock.setAgencyId(record.getAgencyId());
		System.out.println(record.getLevel());
		if (record.getLevel()==1) {
			Headquartersorders headquartersorders=ad.queryOrdersDetailByOrderIdFromH(orderId);
	System.out.println(headquartersorders);
	System.out.println(headquartersorders.getOrderState());
			headquartersorders.setOrderState(orderState);
	System.out.println(headquartersorders.getOrderState());
			hm.updateByPrimaryKey(headquartersorders);
			
			Headquartersorderdetail headquartersorderdetail=ad.queryOrdersConciseByOrderIdFromH(orderId);
			agencystock.setItemId(headquartersorderdetail.getItemId());
			stock=asm.selectOne(agencystock);
			if (stock==null) {
				stock=new Agencystock();
				stock.setItemId(headquartersorderdetail.getItemId());
				stock.setItemStock(headquartersorderdetail.getItemCount());
				stock.setItemName(ad.queryItemstypeById(headquartersorderdetail.getItemId()).getItemName());
				stock.setAgencyId(headquartersorders.getReceiveId());
				asm.insert(stock);
			}else {
				int count=stock.getItemStock()+headquartersorderdetail.getItemCount();
				stock.setItemStock(count);
			}
		}else {
			Agencyorders agencyorders=ad.queryOrdersDetailByOrderIdFromA(orderId);
			Agencyorderdetail agencyorderdetail=ad.queryOrdersConciseByOrderIdFromA(orderId);
			agencyorders.setOrderState(orderState);
			orderMapper.updateByPrimaryKey(agencyorders);
			
			agencystock.setItemId(agencyorderdetail.getItemId());
			stock=asm.selectOne(agencystock);
			if (stock==null) {
				stock=new Agencystock();
				stock.setItemId(agencyorderdetail.getItemId());
				stock.setItemStock(agencyorderdetail.getItemCount());
				stock.setItemName(ad.queryItemstypeById(agencyorderdetail.getItemId()).getItemName());
				stock.setAgencyId(agencyorders.getReceiveId());
				asm.insert(stock);
			}else {
				int count=stock.getItemStock()+agencyorderdetail.getItemCount();
				stock.setItemStock(count);
			}
		}
		
	}
}





















