package xyz.oilpea.wechat.app.api.web.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.net.URLEncoder;

/**
 * @program: sell
 * @description: 对接微信网页授权
 * @author: 01
 * @create: 2018-05-15 15:35
 **/
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

	private static final Logger log = LoggerFactory.getLogger(WechatController.class);

	@Autowired
	private WxMpService wxMpService;

	/**
	 * 获取code参数
	 *
	 * @param returnUrl
	 *            需要跳转的url
	 * @return
	 */
	@GetMapping("/authorize")
	public String authorize(@RequestParam("returnUrl") String returnUrl) {
		// 暂时将我们的回调地址硬编码在这里，方便一会调试
		// String url = "https://zero.mynatapp.cc/sell/wechat/userInfo";
		String url = "https://www.oilpea.xyz/wechat/userInfo";
		// 获取微信返回的重定向url
		System.out.println("a1");
		String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE,
				URLEncoder.encode(returnUrl));
		System.out.println("a2");
		log.info("【微信网页授权】获取code，redirectUrl = {}", redirectUrl);
		System.out.println("a3");
		return "redirect:" + redirectUrl;
	}

	/**
	 * 使用code参数换取access_token信息，并获取到openid
	 *
	 * @param code
	 * @param returnUrl
	 * @return
	 */
	@GetMapping("/userInfo")
	public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) {
		System.out.println("0");
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
		System.out.println("1");
		try {
			System.out.println("2");
			// 使用code换取access_token信息
			wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		} catch (WxErrorException e) {
			log.error("【微信网页授权】异常，{}", e);
			e.printStackTrace();
		}
		System.out.println("3");
		// 从access_token信息中获取到用户的openid
		String openId = wxMpOAuth2AccessToken.getOpenId();
		log.info("【微信网页授权】获取openId，openId = {}", openId);

		// 重定向到我们要跳转的页面
		return "redirect:" + returnUrl + "?openid=" + openId;
	}

	@GetMapping("/hello")
	public String hello1() {
		System.out.println("hello1");
		// String redirectUrl = "https:localhost:89/wechat/hello2?id=5";
		// return "redirect:" + redirectUrl;
		return null;
	}

	@GetMapping("/hello2")
	public void hello2(String id) {
		System.out.println("hello2");
		System.out.println(id);
		String redirectUrl = "htpps://www.oilpea.xyz/wechat/hello2";
	}
}
