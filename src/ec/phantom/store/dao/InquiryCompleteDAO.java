package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ec.phantom.store.util.DBConnector;

public class InquiryCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private String sql = "INSERT INTO inquiry_table (name,qtype,body) VALUES(?,?,?)";



	public void inquiry(String name,String qtype,String body) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, qtype);
			preparedStatement.setString(3, body);

			preparedStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
}
