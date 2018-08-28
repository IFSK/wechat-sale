package xyz.oilpea.wechat.app.api.mapper;

import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.Mapper;
import xyz.oilpea.wechat.app.api.pojo.User;

@Component
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}