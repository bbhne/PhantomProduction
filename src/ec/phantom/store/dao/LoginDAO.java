package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.phantom.store.dto.LoginDTO;
import ec.phantom.store.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * ログインユーザー情報取得メソッド
	 *
	 * @accountId
	 * @userpassword
	 * @return LoginDTO
	 */
	public LoginDTO getLoginUserInfo(String userNumber,String accountId,String userName,String userPassword,String userMail) {

		String sql = "SELECT * FROM user_table where account_id = ? AND user_pass = ? OR user_name = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountId);
			preparedStatement.setString(2, userPassword);
			preparedStatement.setString(3, userName);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setAccountid(resultSet.getString("account_id"));
				loginDTO.setUserPassword(resultSet.getString("user_pass"));
				loginDTO.setUserNumber(resultSet.getString("user_number"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setUserMail(resultSet.getString("user_mail"));

				if(!(resultSet.getString("account_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
