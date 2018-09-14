package xyz.oilpea.wechat.agency.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.agency.dao.AgencyDao;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.LowerLevelService;

@Service
public class ILowerLevelService implements LowerLevelService {
	@Autowired
	AgencyDao ad;

	@Override
	public List<Agency> LowerLevelConciseinfo(String wechatId) {
		// TODO Auto-generated method stub
		Agency agency=ad.queryAgencyByWechatId(wechatId);
		return ad.queryAencyByInvitationCode(agency.getInvitationCode());
	}

	@Override
	public Agency LowerLevelDetailinfo(Integer agencyId) {
		// TODO Auto-generated method stub
		return ad.queryAgencyById(agencyId);
	}

	
}
