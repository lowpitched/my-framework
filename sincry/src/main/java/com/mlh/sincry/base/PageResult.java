package com.mlh.sincry.base;

/**
 * Created by menglihao on 2017/6/12.
 */
public class PageResult<T> extends Result<T>{

	private int pageNo;

	private int pageSize;

	private int totalPageNo;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
}
