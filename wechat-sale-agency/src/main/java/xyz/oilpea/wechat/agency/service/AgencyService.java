package xyz.oilpea.wechat.agency.service;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;

public interface AgencyService {

	public List<Agencyorders> testtwo();

	public void AgencyLogin(String openid);

	public Agency getAgencyByWechatId(String wechatId);
}



