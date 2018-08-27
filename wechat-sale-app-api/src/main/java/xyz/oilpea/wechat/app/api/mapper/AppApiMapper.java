package xyz.oilpea.wechat.app.api.mapper;

import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.Mapper;
import xyz.oilpea.wechat.app.api.pojo.AppApi;

@Component
public interface AppApiMapper extends Mapper<AppApi> {
}