package xyz.oilpea.wechat.agency.service;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agency;

public interface LowerLevelService {
	public List<Agency> LowerLevelConciseinfo(String wechatId);
	
	public Agency LowerLevelDetailinfo(Integer agencyId);
	
}
