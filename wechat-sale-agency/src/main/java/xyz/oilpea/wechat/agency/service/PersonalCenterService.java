package xyz.oilpea.wechat.agency.service;

import xyz.oilpea.wechat.agency.pojo.Agency;

public interface PersonalCenterService {
	public Agency personalInfo(Integer agencyId);
	
	public Agency addBankCard(Integer agencyId);
	
	public void Edit(Agency agency);
}
