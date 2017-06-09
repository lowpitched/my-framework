package com.mlh.sincry.base.service;

import com.mlh.sincry.base.dao.IBaseDao;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by menglihao on 2017/6/9.
 */
public abstract class BaseService<T> implements InitializingBean {

	protected IBaseDao<T> dao;

	protected abstract IBaseDao getDao();

	public int deleteByPrimaryKey(Long id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int insert(T record) {
		return dao.insert(record);
	}

	public int insertSelective(T record) {
		return dao.insertSelective(record);
	}

	public T selectByPrimaryKey(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return dao.updateByPrimaryKey(record);
	}

	protected void init(IBaseDao<T> dao) {
		this.dao = dao;
	}

	public void afterPropertiesSet() throws Exception {
		this.dao = getDao();
	}
}
