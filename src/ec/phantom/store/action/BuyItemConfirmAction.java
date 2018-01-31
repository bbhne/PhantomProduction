package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.BuyItemCompleteDAO;
import ec.phantom.store.dto.SearchDTO;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	private String itemPrice;

	private String itemName;

	private String itemImage;

	public List<SearchDTO> searchList = new ArrayList<SearchDTO>();
	/**
	 * 商品購入情報登録メソッド
	 */
	public String execute() throws SQLException {
		//item_transaction_id, account_id, total_price, total_count, pay
		buyItemCompleteDAO.buyItemInfo(
				session.get("item_transaction_id").toString(),
				session.get("account_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());
		System.out.println("----------------------conf");
		System.out.println(itemPrice);
		System.out.println(itemName);
		System.out.println(itemImage);
		String result = SUCCESS;
		return result;

	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<SearchDTO> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<SearchDTO> searchList) {
		this.searchList = searchList;
	}



}
