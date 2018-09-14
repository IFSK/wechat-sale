package xyz.oilpea.wechat.agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.dao.AgencyDao;
import xyz.oilpea.wechat.agency.mapper.AgencyMapper;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.PersonalCenterService;

@Service
public class IPersonalCenterService implements PersonalCenterService {
	@Autowired
	AgencyDao ad;
	
	@Autowired
	AgencyMapper am;

	@Override
	public Agency personalInfo(Integer agencyId) {
		// TODO Auto-generated method stub
		return ad.queryAgencyById(agencyId);
	}

	@Override
	public Agency addBankCard(Integer agencyId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void Edit(Agency agency) {
		am.updateByPrimaryKey(agency);
	}
}
