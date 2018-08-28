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
	AgencyMapper mapper;

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
	public Agency queryAgencyById(int agencyId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(agencyId);
	}

	// 下级
	@Override
	public List<Agency> queryAencyByInvitationCode(String invitationCode) {// 通过邀请码查看下级
		// TODO Auto-generated method stub
		return mapper.selectByExample(invitationCode);
	}

	// 库存
	@Override
	public List<Agencystock> queryStockByAgencyId(int agencyId) {// 通过经销商ID查询库存
		// TODO Auto-generated method stub
		return stockMapper.selectByExample(agencyId);
	}

	// 订单
	@Override
	public List<Agencyorders> queryOrdersByAgencyIdAndState(int agencyId, int orderState) {
		// TODO Auto-generated method stub
		return null;
	}

}
