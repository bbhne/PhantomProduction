package ec.phantom.store.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirm extends ActionSupport implements SessionAware {

	private String accountId;

	private String userPassword;

	private String userName;

	private String userMail;

	public Map<String,Object> session;

	private String errorMessage;


	public String execute() {

		String result = SUCCESS;

		if(!(accountId.equals("")) && !(userPassword.equals("")) && !(userName.equals("")) && !(userMail.equals(""))) {
			session.put("accountId", accountId);
			session.put("userPassword", userPassword);
			session.put("userName", userName);
			session.put("userMail", userMail);
		}else {
			setErrorMessage("未入力の項目があります!");
			result = ERROR;
		}
		return result;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
