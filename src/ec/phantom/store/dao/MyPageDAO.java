package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ec.phantom.store.dto.MyPageDTO;
import ec.phantom.store.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	/**
	 *
	 * @param user_account_id
	 * @param transaction_number
	 * @return
	 * @throws SQLException
	 */

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String account_id) throws SQLException {

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT * FROM user_buy_item_transaction "
				+ "LEFT JOIN item_table "
				+ "ON user_buy_item_transaction.item_transaction_id = item_table.item_number "
				+ "WHERE user_buy_item_transaction.item_transaction_id = ? "
				+ "AND user_buy_item_transaction.account_id = ?";

		System.out.println("MyPageDAO--------------");
		System.out.println(item_transaction_id);
		System.out.println(account_id);

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,account_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setItemNumber(resultSet.getString("item_number"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));

				System.out.println(dto.getItemNumber());
				System.out.println(dto.getItemName());
				System.out.println(dto.getTotalPrice());
				System.out.println(dto.getTotalCount());
				System.out.println(dto.getPayment());
				System.out.println("-----------------------");

				myPageDTO.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return myPageDTO;
	}

	/**
	 * 商品履歴削除
	 *
	 * @param item_transaction_id
	 * @param account_id
	 * @return
	 * @throws SQLException
	 */
	public int buyItemHistoryDelete(String item_transaction_id,String account_id) throws SQLException {

		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND account_id = ?";

		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, account_id);

			result = preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return result;
	}

}
