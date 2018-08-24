package xyz.oilpea.wechat.app.api.web.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
import xyz.oilpea.wechat.app.api.util.AuthUtil;

@RestController("/wx")
public class WeChatCallBackController {


	@GetMapping("/hello3")
	public void sayHello3() {
		System.out.println("hello3");
	}
}
