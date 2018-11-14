package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Locale;
import javafx.scene.control.Hyperlink;


public class ItemTest {

	/**
	 * Test initialization of Item
	 * @author imc4kmacpro
	 */
	@Test
	public void testCreation() {
		Item i = new Item();
		assertNotNull(i);
	}

	/**
	 * test set/get title
	 */
	@Test
	public void testSetTitle() {
		Item i = new Item();
		i.setTitle("ABCDE");
		assertEquals(i.getTitle(), "ABCDE");
	}
	
	/**
	 * test set/get price
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetPrice() {
		Item i = new Item();
		i.setPrice(3);
		assertEquals(i.getPrice(), 3, 0.001);
	}
	
	/**
	 * test set/get date
	 * this tests valid date
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetDate1() {
		Item i = new Item();
		i.setDate("Nov 8", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		assertEquals(i.getDate(), "Nov 08");
	}
	
	/**
	 * test set/get date
	 * this tests invalid date
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetDate2() {
		Item i = new Item();
		assertEquals(i.getDate(), "No Date");
	}
	
	/**
	 * test set/get date
	 * this tests invalid date format
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetDate3() {
		Item i = new Item();
		i.setDate("Something", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		assertEquals(i.getDate(), "No Date");
	}
	
	/**
	 * test set/get url
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetUrl() {
		Item i = new Item();
		i.setUrl("www.google.com.hk");
		assertEquals(i.getUrl(), "www.google.com.hk");
	}
}
