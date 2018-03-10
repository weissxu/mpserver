package mpserver.controller;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.alibaba.fastjson.JSON;

import mpserver.entity.test.PersonEntity;
import mpserver.mapper.test.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonMapper mapper;
	
	@Autowired
	@Qualifier("testDataSource")
	private DataSource testDataSource;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		logger.info("home..");
		logger.info("testDataSource.."+testDataSource);
		List<PersonEntity> all = mapper.findAll();
		return JSON.toJSONString(all);
	}
	@RequestMapping("/insert")
	@ResponseBody
	String insert() {
		PersonEntity entity = new PersonEntity("weiss", 0);
		entity.setBirthday(new Date());
		entity.setPhone("15700115969");

		mapper.insert(entity);
		
		return "success";
	}
	@RequestMapping("/update")
	@ResponseBody
	String update() {
		PersonEntity entity = mapper.findById(1L);
		entity.setAddress("hangzhoh");
		mapper.update(entity);
		
		return"success.";
	}

}
