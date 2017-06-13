package com.mlh.sincry.util;

import com.alibaba.druid.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by menglihao on 2017/6/13.
 */
public class CookieUtils {

	private CookieUtils(){}

	/**
	 * 设置cookie
	 * @param cookie
	 * @param response
	 */
	public static void setCookie(Cookie cookie, HttpServletResponse response){
		response.addCookie(cookie);
	}

	/**
	 *设置cookie
	 * @param name cookie名称
	 * @param value cookie值
	 * @param args 0 path 2 maxAge 3 domain
	 */
	public static void setCookie(HttpServletResponse response,String name,String value,String... args){
		Cookie cookie = new Cookie(name,value);
		if(null!=args){
			if(args.length>=1) {
				String path = args[0];
				checkPath(path);
				if (StringUtils.isEmpty(path)) {
					cookie.setPath("/");
				} else {
					cookie.setPath(path);
				}
			}else if(args.length>=2){
				String maxAge = args[1];
				if(StringUtils.isEmpty(maxAge)){
					cookie.setMaxAge(60*60*24*7);
				}else{
					cookie.setMaxAge(Integer.parseInt(maxAge));
				}
			}else if(args.length>=3){
				String domain = args[2];
				if(!StringUtils.isEmpty(domain)) {
					cookie.setDomain(domain);
				}
			}
		}
		if(null==args){
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);
		}
		setCookie(cookie,response);
	}

	private static void checkPath(String path) {
		if(!StringUtils.isEmpty(path)){
			if(path.indexOf("/")<0){
				throw new RuntimeException("Illegal cookie path ["+path+"]");
			}
		}
	}

}
