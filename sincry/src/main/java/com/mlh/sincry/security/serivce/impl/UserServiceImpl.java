package com.mlh.sincry.security.serivce.impl;

import com.mlh.sincry.security.dao.UserMapper;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by menglihao on 2017/6/12.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	public User findById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int add(User user) {
		return userMapper.insert(user);
	}

	public int deleteById(long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public int updateById(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	public User login(String username, String password) {
		User user = new User();
		user.setEmail(username);
		user.setPswd(password);
		return userMapper.selectByQuery(user).get(0);
	}
}
