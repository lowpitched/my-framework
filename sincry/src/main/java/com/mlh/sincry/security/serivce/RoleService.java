package com.mlh.sincry.security.serivce;

import com.mlh.sincry.security.pojo.Role;
import com.mlh.sincry.security.pojo.User;

import java.util.List;

/**
 * Created by menglihao on 2017/6/13.
 */
public interface RoleService {

	Role findById(long id);

	int add(Role role);

	int deleteById(long id);

	int updateById(Role role);

	List<String> findRoleByUser(String username);
}
