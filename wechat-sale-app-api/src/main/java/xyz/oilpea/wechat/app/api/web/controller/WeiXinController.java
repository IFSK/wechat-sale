package xyz.oilpea.wechat.app.api.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
public class WeiXinController {

	private static final Logger log = LoggerFactory.getLogger(WeiXinController.class);

	@GetMapping("/auth")
	public void auth(@RequestParam("code") String code) {
		log.info("进入auth方法...");
		log.info("code = {}", code);

		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3761xxxxx1ac6c76&secret=f12caef4d31axxxxx819c4c405541f4&code="
				+ code + "&grant_type=authorization_code";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		log.info("response = {}", response);
	}
}
