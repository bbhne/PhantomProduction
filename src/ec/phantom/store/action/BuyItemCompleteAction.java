package ec.phantom.store.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String itemPrice;

	private String itemName;

	private String itemImage;
	/**
	 * 商品購入情報登録完了メソッド
	 */
	public String execute() {
		System.out.println("----------------comp");
		System.out.println(itemPrice);
		System.out.println(itemName);
System.out.println(itemImage);
		String result = SUCCESS;
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

}
