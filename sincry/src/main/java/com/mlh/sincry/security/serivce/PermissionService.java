package com.mlh.sincry.security.serivce;

import com.mlh.sincry.security.pojo.Permission;

import java.util.List;

/**
 * Created by menglihao on 2017/6/13.
 */
public interface PermissionService {

	Permission findById(long id);

	int add(Permission permission);

	int deleteById(long id);

	int updateById(Permission permission);

	List<String> findPermissionsByUser(String username);

}
