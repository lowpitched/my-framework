package com.mlh.sincry.security.serivce.impl;

import com.mlh.sincry.base.Result;
import com.mlh.sincry.security.dao.UserMapper;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

	public Result checkUserName(String username){
		Result result = new Result();
		User user = userMapper.selectByQuery(username, null);
		if(null==user){
			result.err(101,"用户不存在");
		}else if(User.EnumUserStatus.FREEZE.getCode().equals(user.getStatus())){
			result.err(102,"账户"+User.EnumUserStatus.FREEZE.getName());
		}
		return result;
	}

	public User login(String username, String password) {
		return userMapper.selectByQuery(username, password);
	}
}
