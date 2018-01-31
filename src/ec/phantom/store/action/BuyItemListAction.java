package ec.phantom.store.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemListAction extends ActionSupport implements SessionAware {

	private String orucinus;

	private String scarlet;

	private String maximum;

	private String book;

	private String game;

	private String sound;


	public Map<String,Object> session;

	public String execute() throws SQLException {

		return SUCCESS;

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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
