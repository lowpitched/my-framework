package com.mlh.sincry.security.controller;

import com.alibaba.fastjson.JSON;
import com.mlh.sincry.security.pojo.User;
import com.mlh.sincry.security.serivce.impl.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by menglihao on 2017/6/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/find.do")
	@ResponseBody
	public User find(@ModelAttribute(value="user") User user){
		User u = service.selectByPrimaryKey(user.getId());
		String nickname = u.getNickname();
		System.out.print(nickname);
		return u;
	}

	@RequestMapping("/add.do")
	@ResponseBody
	public String add(User user, HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setContentType("application/json; charset=utf-8");
		response.setContentType("application/xml; charset=utf-8");
		return "中国";
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(User user){
		return null;
	}

	@RequestMapping("/update.do")
	@ResponseBody
	public String update(User user){
		return null;
	}

}
