package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.MyPageDAO;
import ec.phantom.store.dto.MyPageDTO;

public class MyPageAction extends ActionSupport implements SessionAware {
	/**
	 * ログイン情報を格納
	 */
	public Map<String,Object> session;
	/**
	 * マイページ情報取得DAO
	 */
	private MyPageDAO myPageDAO = new MyPageDAO();
	/**
	 * マイページ情報格納DTO
	 */
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	private String message;

	/**
	 * 商品履歴取得メソッド
	 */

	public String execute() throws SQLException {

		if(!session.containsKey("loginUser")) {
			return ERROR;
		}

		//商品履歴を削除しない場合
		if(deleteFlg == null) {
			String item_transaction_id = session.get("item_transaction_id").toString();
			String account_id = session.get("account_id").toString();

			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,account_id);

			Iterator<MyPageDTO> iterator = myPageList.iterator();
			if(!(iterator.hasNext())) {
				myPageList = null;
			}
		//商品履歴を削除する場合
		}else if(deleteFlg.equals("1")) {
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	/**
	 * 商品履歴削除
	 *
	 * @throws SQLException
	 */
	public void delete() throws SQLException {
		String item_transaction_id = session.get("item_transaction_id").toString();
		String account_id = session.get("account_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,account_id);

		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}

	}


	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
