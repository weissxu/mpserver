package mpserver.entity.microprogram;

import mpserver.entity.BaseEntity;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2018年3月7日 下午7:35:00 
* 类说明 
*/
public class SignActivityEntity extends BaseEntity{
	/**
	 * 活动名称
	 */
	private String openId;
	private String activityName;
	private String remark;
	
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
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
