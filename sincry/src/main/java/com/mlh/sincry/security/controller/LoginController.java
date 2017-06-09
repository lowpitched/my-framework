package com.mlh.sincry.security.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by menglihao on 2017/6/8.
 */
@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	UserController controller;

	@RequestMapping(value="/login.do", method={RequestMethod.GET,RequestMethod.POST})
	public String login(HttpServletRequest request){
		System.out.print(controller);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return "forward:/";
	}

	@RequestMapping("/logout.do")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "forward:/";
	}

	@RequestMapping("/testLogin.do")
	public String testLogin(){
		return "login";
	}

}
