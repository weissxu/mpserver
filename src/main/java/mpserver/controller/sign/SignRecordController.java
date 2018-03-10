package mpserver.controller.sign;

import java.util.Date;
import java.util.List;

import mpserver.entity.microprogram.SignActivityEntity;
import mpserver.entity.microprogram.SignRecordEntity;
import mpserver.mapper.microprogram.SignActivityMapper;
import mpserver.mapper.microprogram.SignRecordMapper;
import mpserver.model.ResponseResult;
import mpserver.util.MpserverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.Assert;

/**
 * @author siwei E-mail: siwei666@163.com
 * @version 创建时间：2018年3月7日 下午8:15:01 类说明
 */

@RestController
@RequestMapping("/sign")
public class SignRecordController {

	private static final Logger logger=LoggerFactory.getLogger(SignRecordController.class);
	
	@Autowired
	private SignActivityMapper activityMapper;
	@Autowired
	private SignRecordMapper recordMapper;
	
	@RequestMapping("/recordSign")
	public String recordSign(String openId, Long activityId) {
		ResponseResult result = new ResponseResult();
		try {
			Assert.hasText(openId, "openId can not be null");
			Assert.notNull(activityId, "activityId can not be null");
			
			SignActivityEntity activity = activityMapper.findById(activityId);
			if(activity==null) {
				throw new MpserverException("activity-null", "没有对应的活动");
			}
			
			SignRecordEntity entity=new SignRecordEntity();
			entity.setActivityId(activityId);
			entity.setActivityName(activity.getActivityName());
			entity.setCreator(openId);
			entity.setModifier(openId);
			entity.setGmtCreate(new Date());
			entity.setGmtModified(new Date());
			entity.setOpenId(openId);
			
			recordMapper.insert(entity);
		} catch (Exception e) {
			logger.error("error occured.",e);
			result.setSuccess(false);
			result.setErrorMsg(e.getMessage());
		}

		return result.toJsonString();
	}

	@RequestMapping("/querySignRecordList")
	public String querySignRecordList(String openId) {
		ResponseResult result = new ResponseResult();
		try {
			Assert.hasText("openId", "openId can not be null");
			List<SignRecordEntity> list = recordMapper.findByOpenId(openId);
			result.setSuccess(true);
			result.setResult(list);
		} catch (Exception e) {
			logger.error("error occured.",e);
			result.setSuccess(false);
			result.setErrorMsg(e.getMessage());
		}

		return result.toJsonString();
	}
}
