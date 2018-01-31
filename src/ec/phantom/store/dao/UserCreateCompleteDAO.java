package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ec.phantom.store.util.DBConnector;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private String sql = "INSERT INTO user_table (account_id,user_pass,user_name,user_mail) VALUES(?,?,?,?)";

	public void createUser(String accountId,String userPassword,String userName,String userMail) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountId);
			preparedStatement.setString(2, userPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, userMail);

			preparedStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
}
