package xyz.oilpea.wechat.agency.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import xyz.oilpea.wechat.agency.pojo.Agencyorderdetail;

public interface AgencyorderdetailMapper extends Mapper<Agencyorderdetail> {
//	@Select("select * FROM agencyOrderDetail WHERE order_id = #{orderId }")
//	public List<Agencyorderdetail> queryOrdersDetailByOrderId(@Param("orderId")Integer orderId);
}