package ec.phantom.store.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.BuyItemDAO;
import ec.phantom.store.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	/**
	 * ログインボタン押下時に実行
	 * ログイン画面へ遷移する
	 * @return SUCCESS
	 */
	public String execute() {

		String result = "login";
		if(session.containsKey("accountId")) {
			//home.jsp内のs:form商品購入ボタンで指定されているアクション
			//trueならばアイテム情報を取得、buyItem.jspへ
			//accountIdがsessionになければlogin.jspへ
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("item_transaction_id",buyItemDTO.getItemTransactionId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyitem_price",buyItemDTO.getItemPrice());

			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	public Map<String,Object> session() {
		return this.session;
	}
}
