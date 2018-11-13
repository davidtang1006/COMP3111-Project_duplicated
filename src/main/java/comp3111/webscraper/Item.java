package comp3111.webscraper;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javafx.scene.control.Hyperlink;

public class Item {
	private String title ; 
	private double price ;
	private String url ; // modified by ckchuad, from String to Hyperlink
	private Date date; // added by ckchuad
	private DateFormat format; // added by ckchaud
	
	/**
	 * to initialize url object
	 * @author imc4kmacpro
	 */
	public Item() {
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 *
	 * return value: changed from Hyperlink back to String
	 * @author imc4kmacpro
	 * @param void
	 * @return String
	 * @exception none
	 * 
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @author imc4kmacpro
	 * @param String url 
	 * @return void
	 * @exception none
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	/**
	 * 
	 * @param String date
	 * @param DateFormat format
	 * @exception cannot convert, set date obj to null
	 * @author imc4kmacpro
	 */
	public void setDate(String date, DateFormat format){
		try{
			this.format = format;
			this.date = format.parse(date);
		}catch(ParseException e) {
			System.out.println(e.toString());
			this.date = null;
		}
	}

	/**
	 * if date is null, then return "No Date"
	 * @author imc4kmacpro
	 * @return String
	 */
	public String getDate() {
		if(date != null) {
			return format.format(date);
		}
		return "No Date";
	}
	

}
