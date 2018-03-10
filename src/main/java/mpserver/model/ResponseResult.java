package mpserver.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/** 
* @author siwei E-mail: siwei666@163.com
* @version 创建时间：2018年3月7日 下午7:53:32 
* 类说明 
*/
public class ResponseResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统调用是否成功
	 */
	private boolean success;
	/**
	 * 错误时的相应信息
	 */
	private String errorCode;
	private String errorMsg;
	/**
	 * 返回的结果内容
	 */
	private Object result;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public String toJsonString() {
		return JSON.toJSONString(this);
	}
	
	@Override
	public String toString() {
		return toJsonString();
	}
	

}
