package com.mlh.sincry.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义REALM
 * Created by menglihao on 2017/6/8.
 */
public class SincryRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(SincryRealm.class);

	@Override
	public String getName() {
		return "sincryRealm";
	}

	/**
	 * 登录后授权
	 * @param principals
	 * @return
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String currUsername = (String) super.getAvailablePrincipal(principals);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if(null!=currUsername&&"admin".equals(currUsername)){
			authorizationInfo.addRole("admin");
			authorizationInfo.addStringPermission("admin:manager");
		}else{

		}
		return authorizationInfo;
	}

	/**
	 * 登录验证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		String username = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		if(validUser(username,password)){
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,getName());
			setSession(username,password);
			return authenticationInfo;
		}else{

		}
		return null;
	}

	private void setSession(Object key,Object value){
		Subject subject = SecurityUtils.getSubject();
		if(null!=subject){
			Session session = subject.getSession();
			if(null!=session){
				session.setAttribute(key,value);
			}
		}
	}

	private boolean validUser(String username, String password) {
		return true;
	}
}
