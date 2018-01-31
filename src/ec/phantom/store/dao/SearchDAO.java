package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ec.phantom.store.dto.BuyItemListDTO;
import ec.phantom.store.dto.SearchDTO;
import ec.phantom.store.util.DBConnector;


public class SearchDAO {

	private ArrayList<SearchDTO> searchList =new ArrayList<SearchDTO>();

	public ArrayList<SearchDTO> searchList2 = new ArrayList<SearchDTO>();
	private ArrayList<BuyItemListDTO> buyItemSearchList =new ArrayList<BuyItemListDTO>();


	public ArrayList<SearchDTO> getSearch(String itemNumber,String itemImage,String itemName,String itemType,String itemPrice) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM item_table";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				SearchDTO searchDTO = new SearchDTO();
				searchDTO.setItemNumber(resultSet.getString("item_number"));
				searchDTO.setItemImage(resultSet.getString("item_image"));
				searchDTO.setItemName(resultSet.getString("item_name"));
				searchDTO.setItemType(resultSet.getString("item_type"));
				searchDTO.setItemPrice(resultSet.getString("item_price"));
				searchList.add(searchDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return searchList;
	}



//	public ArrayList<SearchDTO> getSearch2(String itemNumber,String itemImage,String itemName,String itemType,String itemPrice) throws SQLException {
//
//		DBConnector dbConnector = new DBConnector();
//		Connection connection = dbConnector.getConnection();
//
//		String sql = "SELECT * FROM item_info_transaction WHERE item_name LIKE %?%";
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//					while(resultSet.next()) {
//						SearchDTO searchDTO = new SearchDTO();
//						searchDTO.setItemNumber(resultSet.getString("item_number"));
//						searchDTO.setItemImage(resultSet.getString("item_image"));
//						searchDTO.setItemName(resultSet.getString("item_name"));
//						searchDTO.setItemType(resultSet.getString("item_type"));
//						searchDTO.setItemPrice(resultSet.getString("item_price"));
//						searchList.add(searchDTO);
//			}
//
//			}catch(Exception e) {
//				e.printStackTrace();
//		}finally {
//			connection.close();
//		}
//		return searchList;
//	}

	public ArrayList<BuyItemListDTO> getbuyItemType(String orucinus) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM search_type_table";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				BuyItemListDTO  buyItemListDTO = new BuyItemListDTO();
				buyItemListDTO.setOrucinus(resultSet.getString("orcinus"));
				buyItemSearchList.add(buyItemListDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return buyItemSearchList;
	}
}
