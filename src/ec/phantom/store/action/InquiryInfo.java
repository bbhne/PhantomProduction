package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.InquiryInfoDAO;
import ec.phantom.store.dto.InquiryCompleteDTO;

public class InquiryInfo extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	private String name;
	private String qtype;
	private String body;

	public ArrayList<InquiryCompleteDTO> inquiryList = new ArrayList<InquiryCompleteDTO>();

	public String execute() throws SQLException {

		String result = SUCCESS;
		InquiryInfoDAO inquiryInfoDAO = new InquiryInfoDAO();
		inquiryList = inquiryInfoDAO.getInquiryInfo(name, qtype, body);

		return result;
	}

	public ArrayList<InquiryCompleteDTO> getInquiryList() {
		return inquiryList;
	}

	public void setInquiryList(ArrayList<InquiryCompleteDTO> inquiryList) {
		this.inquiryList = (ArrayList<InquiryCompleteDTO>) inquiryList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
