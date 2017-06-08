package com.mlh.test.freemarker;

import com.mlh.test.spring.HelloWorldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by menglihao on 2017/6/8.
 */
@Controller
@RequestMapping("/testFreemarker")
public class TestFreemarkerController {

	@RequestMapping("/test.do")
	public ModelAndView test(){

		ModelAndView mv = new ModelAndView();
		mv.setViewName("freemarkTest");
		System.out.println(1);
		mv.addObject("hello","hello 中国");
		return mv;
	}

}
