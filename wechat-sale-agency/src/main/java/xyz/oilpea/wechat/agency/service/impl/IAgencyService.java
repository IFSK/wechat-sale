package xyz.oilpea.wechat.agency.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.mapper.AgencyMapper;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.service.AgencyService;


@Service
public class IAgencyService implements AgencyService {
	@Autowired
	AgencyMapper mapper;

//	登录
	@Override
	public void AgencyLogin(String openid) {
		Agency agency = new Agency();
		agency.setWechatId(openid);
		Agency agency2 = mapper.selectOne(agency);
		if (agency2 == null) {
			agency2 = new Agency();
			agency2.setStatus(1);
			agency2.setWechatId(openid);
			mapper.insert(agency2);
		}
	}
	
	@Override
	public Agency getAgencyByWechatId(String wechatId) {
		// TODO Auto-generated method stub
		Agency record=new Agency();
		record.setWechatId(wechatId);
		return mapper.selectOne(record);
	}



	@Override
	public List<Agencyorders> testtwo() {
		// TODO Auto-generated method stub
		return null;
	}





	

}






























