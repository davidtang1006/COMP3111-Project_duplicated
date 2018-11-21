package comp3111.webscraper;

import java.text.SimpleDateFormat;
import java.util.Locale;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is for testing the class "Item"
 * @author awtang
 */
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
	 * Try to set a title for an item
	 * @author awtang
	 */
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
		i.setDate("2018 Nov 8", new SimpleDateFormat("yyyy MMM dd", Locale.ENGLISH));
		assertEquals("2018-11-08 00:00", i.getDate());
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