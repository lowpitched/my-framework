package com.mlh.test.spring;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by menglihao on 2017/6/7.
 */
@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	private HelloWorld helloWorld;

	@RequestMapping("/hello.do")
	@ResponseBody
	@RequiresPermissions("hello")
	public String hello(){
		LOGGER.info("***************hello begin**************");
		return helloWorld.say();
	}
	@RequestMapping("/login.do")
	public String login(){
		return "login";
	}

}
