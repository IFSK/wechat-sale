package xyz.oilpea.wechat.sale.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.oilpea.wechat.sale.score.service.impl.Test;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
	Test t;
	
//	@GetMapping()
//	public Itemstype T() {
//		return t.queryItem();
//	}
}
