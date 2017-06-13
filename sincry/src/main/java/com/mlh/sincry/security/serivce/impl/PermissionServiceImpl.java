package com.mlh.sincry.security.serivce.impl;

import com.mlh.sincry.security.dao.PermissionMapper;
import com.mlh.sincry.security.pojo.Permission;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by menglihao on 2017/6/13.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public Permission findById(long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(Permission permission) {
		return permissionMapper.insert(permission);
	}

	@Override
	public int deleteById(long id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(Permission permission) {
		return permissionMapper.updateByPrimaryKey(permission);
	}

	/**
	 * 验证是否有权限
	 * @param username
	 * @return
	 */
	@Override
	public List<String> findPermissionsByUser(String username) {
		return permissionMapper.selectPermissionByUser(username);
	}
}
