package xyz.oilpea.wechat.agency.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.mapper.AgencyMapper;
import xyz.oilpea.wechat.agency.mapper.AgencyordersMapper;
import xyz.oilpea.wechat.agency.mapper.AgencystockMapper;
import xyz.oilpea.wechat.agency.mapper.ItemstypeMapper;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.Itemstype;
import xyz.oilpea.wechat.agency.service.AgencyService;

@Service
public class IAgencyService implements AgencyService {

	@Autowired
	AgencystockMapper stockMapper;

	@Autowired
	ItemstypeMapper im;

	@Autowired
	AgencyMapper agencymapper;

	@Autowired
	AgencyordersMapper ordersMapper;

	@Override
	public List<Agencystock> test(int id) {
		// TODO Auto-generated method stub
		System.out.println("test");
		System.out.println(im.selectAll().size());
		return stockMapper.selectAll();
		// return null;
	}

	@Override
	public List<Itemstype> testtwo() {
		// TODO Auto-generated method stub
		return im.selectAll();
	}


	@Override
	public Agency queryAgencyByWechatId(String wechatId) {
		// TODO Auto-generated method stub
		return agencymapper.selectOneByExample(wechatId);
	}





	@Override
	public Agency queryAgencyById(int agencyId) {
		// TODO Auto-generated method stub
		return agencymapper.selectByPrimaryKey(agencyId);
	}

	// 下级
	@Override
	public List<Agency> queryAencyByInvitationCode(String invitationCode) {// 通过邀请码查看下级
		// TODO Auto-generated method stub
		return agencymapper.selectByExample(invitationCode);
	}

	// 库存
	@Override
	public List<Agencystock> queryStockByAgencyId(int agencyId) {// 通过经销商ID查询库存
		// TODO Auto-generated method stub
		return stockMapper.selectByExample(agencyId);
	}

	// 订单



//订单
	//查询经销商未发货订单：
//		经销商id——>经销商邀请码——>下级id(接受者id)+订单状态——>经销商未发货订单
	@Override
	public List<Agencyorders> queryOrdersByReceiveIdAndState(int agencyId, int orderState) {
		// TODO Auto-generated method stub
		Agency agency=agencymapper.selectByPrimaryKey(agencyId);
		String invitationCode=agency.getInvitationCode()+".";
		List<Agency> agencyList=agencymapper.selectByExample(invitationCode);
		List<Integer> lowerLevelId=null;
		for (Agency agency2 : agencyList) {
			lowerLevelId.add(agency2.getAgencyId());
		}
		List<Agencyorders> agencyorders=null;
		for (Integer integer : lowerLevelId) {
			agencyorders=ordersMapper.selectByExample(integer);
		}
		ordersMapper.selectByExample(orderState);
		return null;
	}

	@Override
	public void AgencyLogin(String openid) {
		Agency agency = new Agency();
		agency.setWechatId(openid);
		Agency agency2 = agencymapper.selectOne(agency);
		if (agency2 == null) {
			agency2 = new Agency();
			agency2.setStatus(1);
			agency2.setWechatId(openid);
			agencymapper.insert(agency2);
		}
	}




}
