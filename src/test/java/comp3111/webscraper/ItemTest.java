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

	
	@Test
	public void testSetTitle() {
		Item i = new Item();
		i.setTitle("ABCDE");
		assertEquals("ABCDE", i.getTitle());
	}
	
	/**
	 * test set/get price
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetPrice() {
		Item i = new Item();
		i.setPrice(3);
		assertEquals(3, i.getPrice(), 0.001);
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
		assertEquals("Nov 08", i.getDate());
	}
	
	/**
	 * test set/get date
	 * this tests invalid date
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetDate2() {
		Item i = new Item();
		assertEquals("No Date", i.getDate());
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
		assertEquals("No Date", i.getDate());
	}
	
	/**
	 * test set/get url
	 * @author imc4kmacpro
	 */
	@Test
	public void testSetUrl() {
		Item i = new Item();
		i.setUrl("www.google.com.hk");
		assertEquals("www.google.com.hk", i.getUrl());
	}
}