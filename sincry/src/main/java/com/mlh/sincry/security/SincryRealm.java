package com.mlh.sincry.security;

import com.mlh.sincry.base.Result;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.PermissionService;
import com.mlh.sincry.security.serivce.RoleService;
import com.mlh.sincry.security.serivce.UserService;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义REALM
 * Created by menglihao on 2017/6/8.
 */
public class SincryRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(SincryRealm.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private RoleService roleService;

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
			List<String> roles = roleService.findRoleByUser(currUsername);
			authorizationInfo.addRoles(roles);
			List<String> permissions = permissionService.findPermissionsByUser(currUsername);
			authorizationInfo.addStringPermissions(permissions);
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
		char[] pwd = usernamePasswordToken.getPassword();
		if(null==pwd){
			throw new AuthenticationException("密码不能为空");
		}
		String password = new String(pwd);
		if(validUser(username,password)){
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,getName());
			setSession(username,password);
			return authenticationInfo;
		}else{
			throw new AuthenticationException("密码错误");
		}
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
		password = encodePassword(password);
		User user = userService.login(username, password);
		if(null!=user){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 加密算法
	 * @param password
	 * @return
	 */
	private String encodePassword(String password) {
		return password;
	}

}
