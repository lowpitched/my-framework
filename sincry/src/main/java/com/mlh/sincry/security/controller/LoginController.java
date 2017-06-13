package com.mlh.sincry.security.controller;

import com.alibaba.druid.util.StringUtils;
import com.mlh.sincry.base.Result;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.UserService;
import com.mlh.sincry.util.CookieUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by menglihao on 2017/6/8.
 */
@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

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
	@ResponseBody
	public Result login(@ModelAttribute(value="user") User user,
	                    @RequestParam(value="rememberMe") String rememberMe,
	                    HttpServletResponse response){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(),user.getPswd());
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return new Result();
	}

	@RequestMapping("/testLogin.do")
	public String testLogin(){
		return "login";
	}

	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public Result checkUsername(User user){
		Result result = userService.checkUserName(user.getEmail());
		return result;
	}

}
