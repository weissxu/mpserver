package mpserver.controller.sign;

import java.util.Date;
import java.util.List;

import mpserver.entity.microprogram.SignActivityEntity;
import mpserver.mapper.microprogram.SignActivityMapper;
import mpserver.model.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siwei E-mail: siwei666@163.com
 * @version 创建时间：2018年3月7日 下午7:49:38 类说明
 */
@RestController
@RequestMapping("/sign")
public class SignActivityController {

	private static final Logger logger = LoggerFactory.getLogger(SignActivityController.class);

	@Autowired
	private SignActivityMapper activityMapper;

	@RequestMapping("/createActivity")
	public String createActivity(String openId, String activityName, String remark) {
		logger.info("param: {}", activityName);
		ResponseResult result = new ResponseResult();

		try {
			Assert.hasText(openId, "openId can not be null");
			Assert.hasText(activityName, "activityName can not be null");
			

			SignActivityEntity entity = new SignActivityEntity();
			entity.setOpenId(openId);
			entity.setActivityName(activityName);
			entity.setRemark(remark);
			entity.setCreator(openId);
			entity.setModifier(openId);
			entity.setGmtCreate(new Date());
			entity.setGmtModified(new Date());

			activityMapper.insert(entity);

			result.setSuccess(true);
			result.setResult(entity);

		} catch (Exception e) {
			logger.error("error occured.", e);
			result.setSuccess(false);
			result.setErrorMsg(e.getMessage());
		}
		return result.toJsonString();
	}

	/**
	 * 
	 * @param openId
	 * @return
	 */
	@RequestMapping("/queryActivityList")
	public String queryActivityList(String openId) {
		logger.info("openId: {}", openId);
		ResponseResult result = new ResponseResult();

		try {
			Assert.hasText(openId, "openId can not be null");
			
			List<SignActivityEntity> list = activityMapper.findByOpenId(openId);
			result.setSuccess(true);
			result.setResult(list);
		} catch (Exception e) {
			logger.error("error occured.", e);
			result.setSuccess(false);
			result.setErrorMsg(e.getMessage());
		}
		return result.toJsonString();
	}

	@RequestMapping("/queryBindKey")
	public String queryBindKey(Long activityId) {
		ResponseResult result = new ResponseResult();
		result.setSuccess(true);
		result.setResult(true);

		return result.toJsonString();
	}
}
