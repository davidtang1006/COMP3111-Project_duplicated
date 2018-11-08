package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class ItemTest {

	@Test
	public void testCreation() {
		Item i = new Item();
		assertNotNull(i);
	}

	@Test
	public void testSetTitle() {
		Item i = new Item();
		i.setTitle("ABCDE");
		assertEquals(i.getTitle(), "ABCDE");
	}
	
	@Test
	public void testSetPrice() {
		Item i = new Item();
		i.setPrice(3);
		assertEquals(i.getPrice(), 3, 0.001);
	}
	
//	@Test
//	public void testSetUrl() {
//		Item i = new Item();
//		i.setUrl("https://google.com.hk");
//		assertEquals(i.getUrl(), "https://google.com.hk");
//	}
	
	@Test
	public void testSetDate() {
		Item i = new Item();
		i.setDate("Nov 8", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		assertEquals(i.getDate(), "Nov 08");
	}
}
