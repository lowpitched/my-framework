package com.mlh.sincry.security.controller;

import com.mlh.sincry.security.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by menglihao on 2017/6/8.
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}

	@RequestMapping("/toUnauthorized.do")
	public String toUnauthorized(){
		return "unauthorized";
	}

	@RequestMapping("/logout.do")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "forward:/";
	}

	@RequestMapping("/login.do")
	public String login(User user){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(),user.getPswd());
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return "forward:/";
	}

	@RequestMapping("/testLogin.do")
	public String testLogin(){
		return "login";
	}

}
