package xyz.oilpea.wechat.app.api.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.oilpea.wechat.app.api.mapper.UserMapper;
import xyz.oilpea.wechat.app.api.pojo.User;
import xyz.oilpea.wechat.app.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public void userLogin(String id) {
		User user = usermapper.selectByPrimaryKey(id);
		if (user == null) {
			user = new User();
			user.setScore(0);
			user.setStatus(1);
			user.setWechatId(id);
			usermapper.insert(user);
		}
	}

	public void test() {
		User user = new User();
		// user.setWechatId("123123");
		// user.setStatus(1);
		// user.setScore(0);
		user.setUserId(1);
		// System.out.println(usermapper.getClass());
		usermapper.select(user);
		// usermapper.insert(user);
	}

}
