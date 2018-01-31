package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ec.phantom.store.dao.SearchDAO;
import ec.phantom.store.dto.BuyItemListDTO;
import ec.phantom.store.dto.SearchDTO;

public class SearchAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private String itemNumber;
	private String itemImage;
	private String itemName;
	private String itemType;
	private String itemPrice;

	private String orucinus;

	private String scarlet;

	private String maximum;

	private String book;

	private String game;

	private String sound;

	private BuyItemListDTO buyItemList = new BuyItemListDTO();

	public List<SearchDTO> searchList = new ArrayList<SearchDTO>();
	public List<SearchDTO> searchList2 = new ArrayList<SearchDTO>();

	//テキストエリアに入力されたらDAOからsql文を呼び出す? isEmpty?

	public String execute() throws SQLException {

		String result = SUCCESS;
		SearchDAO searchDAO = new SearchDAO();
		searchList = searchDAO.getSearch(itemNumber, itemImage, itemName, itemType,itemPrice);
		return result;

	}



	public List<SearchDTO> getSearchList() {
		return searchList;
	}



	public void setSearchList(List<SearchDTO> searchList) {
		this.searchList = searchList;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}



	public String getOrucinus() {
		return orucinus;
	}



	public void setOrucinus(String orucinus) {
		this.orucinus = orucinus;
	}



	public String getScarlet() {
		return scarlet;
	}



	public void setScarlet(String scarlet) {
		this.scarlet = scarlet;
	}



	public String getMaximum() {
		return maximum;
	}



	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}



	public String getBook() {
		return book;
	}



	public void setBook(String book) {
		this.book = book;
	}



	public String getGame() {
		return game;
	}



	public void setGame(String game) {
		this.game = game;
	}



	public String getSound() {
		return sound;
	}



	public void setSound(String sound) {
		this.sound = sound;
	}



	public BuyItemListDTO getBuyItemList() {
		return buyItemList;
	}



	public void setBuyItemList(BuyItemListDTO buyItemList) {
		this.buyItemList = buyItemList;
	}



}
