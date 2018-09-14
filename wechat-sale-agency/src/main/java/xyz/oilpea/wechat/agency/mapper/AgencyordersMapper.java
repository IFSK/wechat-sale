package xyz.oilpea.wechat.agency.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import xyz.oilpea.wechat.agency.pojo.Agencyorders;

public interface AgencyordersMapper extends Mapper<Agencyorders> {
	
//	@Select("select * FROM agencyOrders where receive_id = #{receiveId} and order_state = #{orderState}")
//	public List<Agencyorders> queryordersByReceiveIdAndState(@Param("receiveId") Integer receiveId,@Param("orderState")Integer orderState);
//	
//	@Select("select * FROM agencyOrders WHERE send_id = #{sendId} and order_state = #{orderState }")
//	public List<Agencyorders> queryordersBySendIdAndState(@Param("sendId")Integer sendId,@Param("orderState")Integer orderState);
//	
//	@Select("select * FROM agencyOrders WHERE order_id = #{orderId }")
//	public List<Agencyorders> queryordersBySendIdAndState(@Param("orderId")Integer orderId);
}