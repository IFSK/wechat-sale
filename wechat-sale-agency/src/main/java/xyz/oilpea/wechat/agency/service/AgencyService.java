package xyz.oilpea.wechat.agency.service;

import java.util.List;

import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;
import xyz.oilpea.wechat.agency.pojo.Agencystock;
import xyz.oilpea.wechat.agency.pojo.Itemstype;

public interface AgencyService {

	public List<Agencystock> test(int id);

	public List<Agencystock> queryStockByAgencyId(int agencyId);

	public List<Itemstype> testtwo();

	public Agency queryAgencyById(int agencyId);

	public List<Agency> queryAencyByInvitationCode(String invitationCode);

	public List<Agencyorders> queryOrdersByReceiveIdAndState(int agencyId, int orderState);

	public Agency queryAgencyByWechatId(String wechatId);

	public void AgencyLogin(String openid);

	public void testtest() ;
}
