package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.phantom.store.dto.AdminLoginDTO;
import ec.phantom.store.util.DBConnector;

public class AdminLoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private AdminLoginDTO adminLoginDTO = new AdminLoginDTO();

	/**
	 * ログインユーザー情報取得メソッド
	 *
	 * @accountId
	 * @userpassword
	 * @return LoginDTO
	 */
	public AdminLoginDTO getLoginAdminInfo(String userNumber,String accountId,String userName,String userPassword,String userMail) {

		String sql = "SELECT * FROM admin_table where account_id = ? AND user_pass = ? OR user_name = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountId);
			preparedStatement.setString(2, userPassword);
			preparedStatement.setString(3, userName);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				adminLoginDTO.setAccountid(resultSet.getString("account_id"));
				adminLoginDTO.setUserPassword(resultSet.getString("user_pass"));
				adminLoginDTO.setUserNumber(resultSet.getString("user_number"));
				adminLoginDTO.setUserName(resultSet.getString("user_name"));
				adminLoginDTO.setUserMail(resultSet.getString("user_mail"));

				if(!(resultSet.getString("account_id").equals(null))) {
					adminLoginDTO.setLoginFlg(true);
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return adminLoginDTO;
	}
	public AdminLoginDTO getAdminLoginDTO() {
		return adminLoginDTO;
	}
}
