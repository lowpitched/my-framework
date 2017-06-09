package com.mlh.sincry.security.serivce.impl;

import com.mlh.sincry.base.dao.IBaseDao;
import com.mlh.sincry.base.service.BaseService;
import com.mlh.sincry.security.mapper.UserMapper;
import com.mlh.sincry.security.pojo.Permission;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by menglihao on 2017/6/9.
 */
@Service
public class UserService extends BaseService<User> implements IUserService{
	@Autowired
	private UserMapper dao;

	public UserService(){
	}

	protected IBaseDao getDao() {
		return this.dao;
	}

}
