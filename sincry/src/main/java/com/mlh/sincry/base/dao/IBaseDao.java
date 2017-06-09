package com.mlh.sincry.base.dao;

import com.mlh.sincry.security.pojo.Permission;

/**
 * Created by menglihao on 2017/6/9.
 */
public interface IBaseDao<T> {

	int deleteByPrimaryKey(Long id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

}
