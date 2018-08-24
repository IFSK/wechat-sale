package xyz.oilpea.wechat.app.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: sell
 * @description: 测试号相关信息的配置类
 * @author: 01
 * @create: 2018-05-15 15:50
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat") // 载入配置文件里前缀为wechat的配置信息
public class WechatAccountConfig {
	private String mpAppId;
	private String mpAppSecret;

	public String getMpAppId() {
		return mpAppId;
	}

	public void setMpAppId(String mpAppId) {
		this.mpAppId = mpAppId;
	}

	public String getMpAppSecret() {
		return mpAppSecret;
	}

	public void setMpAppSecret(String mpAppSecret) {
		this.mpAppSecret = mpAppSecret;
	}

}