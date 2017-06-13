package com.mlh.sincry.security.serivce.impl;

import com.mlh.sincry.security.dao.RoleMapper;
import com.mlh.sincry.security.pojo.Role;
import com.mlh.sincry.security.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by menglihao on 2017/6/13.
 */
@Service
public class RoleServiceImple implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Role findById(long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(Role role) {
		return roleMapper.insert(role);
	}

	@Override
	public int deleteById(long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(Role role) {
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public List<String> findRoleByUser(String username) {
		return roleMapper.selectRoleByUser(username);
	}
}
