package com.mlh.test.mybatis;

import com.alibaba.fastjson.JSON;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by menglihao on 2017/6/7.
 */
@Controller
@RequestMapping("/testMyBatis")
public class TestMyBatisController {

	@Resource
	private PersonMapper personMapper;

	@RequestMapping("/testMyBatis.do")
	@ResponseBody
	public String testMyBatis(HttpServletRequest request){
		try {
			List<Person> persons = personMapper.findAll();
			return JSON.toJSONString(persons);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
