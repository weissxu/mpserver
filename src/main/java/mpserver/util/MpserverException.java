package mpserver.util;

/** 
* @author siwei E-mail: siwei666@163.com
* @version 创建时间：2018年3月8日 下午10:27:55 
* 类说明 
*/
public class MpserverException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorKey;
	private String errorMsg;
	
	
	public MpserverException() {
	}
	
	public MpserverException(String errorKey, String errorMsg) {
		super();
		this.errorKey = errorKey;
		this.errorMsg = errorMsg;
	}
	public String getErrorKey() {
		return errorKey;
	}
	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String getMessage() {
		return errorMsg;
	}
}
