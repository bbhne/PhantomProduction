package ec.phantom.store.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.BuyItemDAO;
import ec.phantom.store.dao.LoginDAO;
import ec.phantom.store.dto.BuyItemDTO;
import ec.phantom.store.dto.LoginDTO;

/**
 *
 * Login.jspからID、パスワードを受け取り
 * DBへ問い合わせをする
 *
 * @author el
 *
 *@accountId
 *@userPassword
 *
 *@return result
 */

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ユーザー登録順番号
	 */
	private String userNumber;
	/**
	 * ログインID
	 */
	private String accountId;
	/**
	 * ログインユーザー名
	 */
	private String userName;
	/**
	 * ログインパスワード
	 */
	private String userPassword;
	/**
	 * ログインメール
	 */
	private String userMail;
	/**
	 * ログイン情報を格納
	 */
	public Map<String,Object> session;
	/**
	 * ログイン情報取得DAO
	 */
	private LoginDAO loginDAO = new LoginDAO();
	/**
	 * ログイン情報格納DTO
	 */
	private LoginDTO loginDTO = new LoginDTO();
	/**
	 * アイテム情報を取得
	 */
	private BuyItemDAO buyItemDAO = new BuyItemDAO();


	/**
	 * 実行メソッド
	 */

	public String execute() {

		String result = ERROR;

		//ログイン実行
		loginDTO = loginDAO.getLoginUserInfo(userNumber,accountId,userName,userPassword,userMail);

		session.put("loginUser", loginDTO);
		//ERRORの時点でsession.putに値が入っているからjspのuserNameがないのに表示される

		//ログイン情報を比較
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;

			//アイテム情報を取得
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("account_id",loginDTO.getAccountId());
			session.put("item_transaction_id",buyItemDTO.getItemTransactionId());
			session.put("Item_name",buyItemDTO.getItemName());
			session.put("Item_price",buyItemDTO.getItemPrice());

			System.out.println(accountId);
			System.out.println(userPassword);
			return result;

		}
		return result;
	}

	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
