package xyz.oilpea.wechat.sale.score.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.sale.score.mapper.ScoreitemstypeMapper;
import xyz.oilpea.wechat.sale.score.mapper.ScoreitmeMapper;
import xyz.oilpea.wechat.sale.score.service.ScoreService;

@Service
public class IScoreService implements ScoreService {
	
	@Autowired
	ScoreitemstypeMapper itemstypeMapper;
	
	@Autowired
	ScoreitmeMapper itmeMapper;

	@Override
	public void queryUserByWechatId(String wechatID) {
		// TODO Auto-generated method stub
		
	}

}
