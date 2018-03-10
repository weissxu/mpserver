package mpserver.entity.microprogram;

import mpserver.entity.BaseEntity;

/** 
* @author siwei E-mail: siwei666@163.com
* @version 创建时间：2018年3月7日 下午7:45:47 
* 类说明 
*/
public class SignRecordEntity extends BaseEntity{
	private String openId;
	private Long activityId;
	private String activityName;
	private String remark;
	
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
