package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.InquiryCompleteDAO;

public class InquiryCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	private String userName;
	private String qtype;
	private String body;


	private InquiryCompleteDAO inquiryDAO = new InquiryCompleteDAO();

	private String errorMessage;

	public String execute() throws SQLException {

		String result = SUCCESS;

		if(!(userName.equals("")) && !(body.equals(""))) {
			session.put("inquiry", userName);
			session.put("qtype",qtype);
			session.put("body", body);
			if(!(userName.equals(null)) && !(body.equals(null))) {
						inquiryDAO.inquiry(
						session.get("inquiry").toString(),
						session.get("qtype").toString(),
						session.get("body").toString()
						);
			}
		}else {
			setErrorMessage("未入力です！");
			result = ERROR;
		}

		return result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



}
