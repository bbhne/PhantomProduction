package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ec.phantom.store.util.DBConnector;

public class BuyItemCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id,account_id,total_price,total_count,pay) VALUES(?,?,?,?,?)";

		/**
		 * 商品購入情報登録メソッド
		 *
		 * @param item_transaction_id
		 * @param account_id
		 * @param total_price
		 * @param total_count
		 * @param pay
		 * @throws SQLException
		 */
	public void buyItemInfo(String item_transaction_id,String account_id,String total_price,String total_count,String pay) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, account_id);
			preparedStatement.setString(3, total_price);
			preparedStatement.setString(4, total_count);
			preparedStatement.setString(5, pay);

			preparedStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}
}
