package ec.phantom.store.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	/**
	 * アイテム購入個数
	 */
	private int count;

	private int payment;

	private int itemNumber;

	/**
	 * 支払い方法
	 */
	private String pay;

	/**
	 * アイテム情報格納
	 */
	public Map<String,Object> session;

	/**
	 * 商品情報取得メソッド
	 */

	private String errorMessage;

	private String buyItem_image;
	private String buyItem_name;
	private String buyItem_price;


	public String execute() {

		if(!session.containsKey("loginUser")) {
			setErrorMessage("購入する場合はログインしてください!");
			return ERROR;

		}

		String result = SUCCESS;

		session.put("buyItem_image", buyItem_image);
		session.put("buyItem_name", buyItem_name);
		session.put("buyItem_price", buyItem_price);

		session.put("count", count);

		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("Item_price").toString());

		session.put("total_price", intCount * intPrice);
		String payment;
System.out.println(pay);
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		}else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
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

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getBuyItem_image() {
		return buyItem_image;
	}

	public void setBuyItem_image(String buyItem_image) {
		this.buyItem_image = buyItem_image;
	}

	public String getBuyItem_name() {
		return buyItem_name;
	}

	public void setBuyItem_name(String buyItem_name) {
		this.buyItem_name = buyItem_name;
	}

	public String getBuyItem_price() {
		return buyItem_price;
	}

	public void setBuyItem_price(String buyItem_price) {
		this.buyItem_price = buyItem_price;
	}

	public Map<String, Object> getSession() {
		return session;
	}



}
