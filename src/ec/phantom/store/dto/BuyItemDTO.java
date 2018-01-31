package ec.phantom.store.dto;

public class BuyItemDTO {

	public int itemTransactionId;

	public String accountId;

	public String itemName;

	public String itemPrice;


	public int getItemTransactionId() {
		return itemTransactionId;
	}

	public void setItemTransactionId(int itemTransactionId) {
		this.itemTransactionId = itemTransactionId;
	}



	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


}
