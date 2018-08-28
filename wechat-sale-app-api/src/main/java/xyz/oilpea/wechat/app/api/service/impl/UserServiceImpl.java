package xyz.oilpea.wechat.app.api.service.impl;

import java.util.List;

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
		User user = new User();
		user.setWechatId(id);
		User user2 = usermapper.selectOne(user);
		if (user2 == null) {
			user2 = new User();
			user2.setScore(0);
			user2.setStatus(1);
			user2.setWechatId(id);
			usermapper.insert(user2);
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

	@Override
	public void test2() {
		System.out.println(usermapper.selectAll().size());
		User user = new User();
		user.setScore(0);
		user.setStatus(1);
		user.setWechatId("asdasdasd");
		usermapper.insert(user);
	}

}
