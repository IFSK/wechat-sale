package xyz.oilpea.wechat.app.api.mapper;

import tk.mybatis.mapper.common.Mapper;
import xyz.oilpea.wechat.app.api.pojo.User;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}