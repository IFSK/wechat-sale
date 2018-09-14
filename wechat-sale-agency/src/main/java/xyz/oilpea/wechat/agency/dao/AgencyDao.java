package xyz.oilpea.wechat.agency.dao;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorderdetail;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.Headquartersorderdetail;
import xyz.oilpea.wechat.agency.pojo.Headquartersorders;
import xyz.oilpea.wechat.agency.pojo.Itemstype;

public interface AgencyDao {
	public Agency queryAgencyByWechatId(String wechatId);//	用wechatID查詢Agency
	
	public Agency queryAgencyById(int agencyId);//	用AgencyID查询Agency
	
// 下级
	public List<Agency> queryAencyByInvitationCode(String invitationCode);// 	通过邀请码查看下级	
	
//库存
	public List<Agencystock> queryStockByAgencyId(int agencyId);//	通过经销商ID查询库存
	
//订单系统
	public List<Agencyorders> queryOrdersByLowerLevelIdAndState(String invitationCode, int orderState);
	
	public List<Agencyorderdetail> queryOrdersBySendIdAndState(int sendId, int orderState);
	//我的订单ReceiveId=agencyId(我的ID)
	public List<Agencyorderdetail> queryOrdersByReceiveIdAndStateFromA(int receiveId, int orderState);
	
	public List<Headquartersorderdetail> queryOrdersByReceiveIdAndStateFromH(int receiveId, int orderState);
	
	public Itemstype queryItemstypeById(Integer itemId);
	
	public Agencyorders queryOrdersDetailByOrderIdFromA(Integer orderId);
	
	public Agencyorderdetail queryOrdersConciseByOrderIdFromA(Integer orderId);
	
	public Headquartersorders queryOrdersDetailByOrderIdFromH(Integer orderId);
	
	public Headquartersorderdetail queryOrdersConciseByOrderIdFromH(Integer orderId);
	
}
