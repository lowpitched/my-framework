package com.mlh.sincry.security.serivce;

import com.mlh.sincry.security.dao.UserMapper;
import com.mlh.sincry.security.pojo.User;

/**
 * Created by menglihao on 2017/6/12.
 */
public interface UserService {

	User findById(long id);

	int add(User user);

	int deleteById(long id);

	int updateById(User user);

	User login(String username,String password);

}
