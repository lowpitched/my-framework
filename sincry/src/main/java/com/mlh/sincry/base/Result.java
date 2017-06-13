package com.mlh.sincry.base;

import java.util.List;

/**
 * Created by menglihao on 2017/6/12.
 */
public class Result<T> {

	public static final int SUCCESS_CODE = 0;

	public static final int UNKONWN_ERR_CODE= 100;

	private int code = SUCCESS_CODE;

	private String message = "OK";

	private boolean success = true;

	private List<T> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		success = success;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void err(Integer code,String message){
		this.success = false;
		if(null!=code) {
			this.code = code;
		}else{
			code = UNKONWN_ERR_CODE;
		}
		this.message = message;

	}
}
