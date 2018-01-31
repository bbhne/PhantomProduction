package ec.phantom.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ec.phantom.store.dto.InquiryCompleteDTO;
import ec.phantom.store.util.DBConnector;

public class InquiryInfoDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ArrayList<InquiryCompleteDTO> inquiryList = new ArrayList<InquiryCompleteDTO>();

	private String sql = "SELECT name,qtype,body FROM inquiry_table";

	public ArrayList<InquiryCompleteDTO> getInquiryInfo(String name,String qtype,String body) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				InquiryCompleteDTO inquiryDTO = new InquiryCompleteDTO();
				inquiryDTO.setName(resultSet.getString("name"));
				inquiryDTO.setQtype(resultSet.getString("qtype"));
				inquiryDTO.setBody(resultSet.getString("body"));
				inquiryList.add(inquiryDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return inquiryList;
		}

}


