package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.phantom.store.dto.BuyItemDTO;
import ec.phantom.store.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return BuyItemDTO
	 */
	public BuyItemDTO getBuyItemInfo() {

		String sql = "SELECT item_transaction_id,item_name,item_price FROM item_table";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				buyItemDTO.setItemTransactionId(resultSet.getInt("item_transaction_id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

}
