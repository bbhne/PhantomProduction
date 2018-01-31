package ec.phantom.store.dto;

public class LoginDTO {

	//ユーザーナンバー
	private String userNumber;
	//ユーザーーアカウントID
	private String accountId;
	//ユーザー名
	private String userName;
	//ユーザーパスワード
	private String userPassword;
	//メール
	private String userMail;

	private boolean loginFlg = false;





	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountid(String accountid) {
		this.accountId = accountid;
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
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}



}
