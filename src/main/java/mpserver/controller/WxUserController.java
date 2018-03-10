package mpserver.controller;

import mpserver.model.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siwei E-mail: siwei666@163.com
 * @version 创建时间：2018年3月7日 下午8:15:01 类说明
 */

@RestController
@RequestMapping("/wxuser")
public class WxUserController {

	@RequestMapping("/recordSign")
	public String recordSign(String openId, Long activityId) {
		ResponseResult result = new ResponseResult();

		return result.toJsonString();
	}

	@RequestMapping("/queryRecordSignList")
	public String queryRecordSignList(String openId) {
		ResponseResult result = new ResponseResult();

		return result.toJsonString();
	}
}
