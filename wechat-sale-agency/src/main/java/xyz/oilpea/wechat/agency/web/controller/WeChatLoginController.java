package xyz.oilpea.wechat.agency.web.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;
import xyz.oilpea.wechat.agency.pojo.Agency;
import xyz.oilpea.wechat.agency.service.AgencyService;
import xyz.oilpea.wechat.agency.util.AuthUtil;

@Controller
@RequestMapping("/wechat")
public class WeChatLoginController {
	private static final long serialVersionUID = 1L;
	@Autowired
	AgencyService agencyService;
	
//	@Autowired
//	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;

	@GetMapping("/agencylogin")
	public String auth() {

		// 第一步：引导用户进入授权页面同意授权，获取code

		// 回调地址
		// String backUrl = "http://suliu.free.ngrok.cc/WxAuth/callBack"; //第1种情况使用
		System.out.println("l1");
		String backUrl = "http://www.oilpea.xyz/wechat/userinfo";// 第2种情况使用，这里是web.xml中的路径

		// 授权页面地址
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID + "&redirect_uri="
				+ URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";

		// 重定向到授权页面
		System.out.println("l2");
		System.out.println("url地址:" + url);
		return "redirect:" + url;
	}

	@GetMapping("/userinfo")
	public String userInfo(String code) throws ClientProtocolException, IOException {

		// 第二步：通过code换取网页授权access_token

		// 从request里面获取code参数(当微信服务器访问回调地址的时候，会把code参数传递过来)

		System.out.println("u1");
		System.out.println("code:" + code);

		// 获取code后，请求以下链接获取access_token
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID + "&secret="
				+ AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";

		// 通过网络请求方法来请求上面这个接口
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		System.out.println("u2");
		System.out.println("==========================jsonObject" + jsonObject);

		// 从返回的JSON数据中取出access_token和openid，拉取用户信息时用
		String token = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		System.out.println("u3");
		// 第三步：刷新access_token（如果需要）

		// 第四步：拉取用户信息(需scope为 snsapi_userinfo)
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=" + openid
				+ "&lang=zh_CN";
		// 通过网络请求方法来请求上面这个接口
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println("登录成功");
		System.out.println(userInfo);
		agencyService.AgencyLogin(openid);
		session.setAttribute("wechatId", openid);
		return "/delivery";
	}

	@GetMapping("/test1")
	public String test1() {
		System.out.println("test1");
		String agencyWechatId="o97Es1GlC7vFb1ofxKDtrQ_5D8Jc";
		Cookie c=new Cookie("agencyWechatId", agencyWechatId);
		c.setPath("/");
//		if(agencyWechatId!=null) {
//			c.setMaxAge(60*60*24*7);
//		}else {
//			c.setMaxAge(0);
//		}
		response.addCookie(c);
		System.out.println("test1");
		return "/delivery";
	}
	
	
	@GetMapping("/test11")
	public String test11() {
		System.out.println("test11");
		String agencyWechatId="o97Es1GlC7vFb1ofxKDtrQ_5D8yy";
		Cookie c=new Cookie("agencyWechatId", agencyWechatId);
		c.setPath("/");
//		if(agencyWechatId!=null) {
//			c.setMaxAge(60*60*24*7);
//		}else {
//			c.setMaxAge(0);
//		}
		response.addCookie(c);
		System.out.println("test11");
		return "/delivery";
	}
	
}










