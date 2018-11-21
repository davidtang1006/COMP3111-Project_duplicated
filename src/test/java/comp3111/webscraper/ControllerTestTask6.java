package comp3111.webscraper;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTestTask6 {
	/**
	 * test update search list method
	 * a list should be assigned to currSearch
	 * @author imc4kmacpro
	 */
	@Test
	public void testUpdateSearchListsFirstAdd() {
		Controller c = new Controller();
		Vector<Item> items_v = new Vector<Item>();
		Item item = new Item();
		item.setTitle("haha");
		item.setPrice(3.333);
		item.setDate("Nov 08", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		item.setUrl("www.google.com.hk");
		items_v.add(item);
		List<Item> items_l = items_v;
		c.updateSearchListsTest(items_l);
		assertEquals(items_l, c.getCurrSearch());
	}
	
	/**
	 * test update search list method
	 * after updating twice, the original currSearch should go to lastSearch
	 * currSearch should store the new list
	 * 
	 * this method tests the currSearch
	 * @author imc4kmacpro
	 */
	@Test
	public void testUpdateSearchListsCurrSearch() {
		Controller c = new Controller();
		Vector<Item> items_v = new Vector<Item>();
		Item item = new Item();
		item.setTitle("haha");
		item.setPrice(3.333);
		item.setDate("Nov 08", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		item.setUrl("www.google.com.hk");
		items_v.add(item);
		List<Item> items_l = items_v;
		c.updateSearchListsTest(items_l);
		
		Item item2 = new Item();
		item2.setTitle("2nd item");
		item2.setPrice(1000000);
		item2.setDate("Oct 31", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		item2.setUrl("www.youtube.com.hk");
		items_v.add(item2);
		List<Item> items2_l = items_v;
		c.updateSearchListsTest(items2_l);
		assertEquals(items2_l, c.getCurrSearch());
	}
	
	/**
	 * test update search list method
	 * after updating twice, the original currSearch should go to lastSearch
	 * currSearch should store the new list
	 * 
	 * this method tests the lastSearch
	 * @author imc4kmacpro
	 */
	@Test
	public void testUpdateSearchListsLastSearch() {
		Controller c = new Controller();
		Vector<Item> items_v = new Vector<Item>();
		Item item = new Item();
		item.setTitle("haha");
		item.setPrice(3.333);
		item.setDate("Nov 08", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		items_v.add(item);
		List<Item> items_l = items_v;
		c.updateSearchListsTest(items_l);
		assertEquals(items_l, c.getCurrSearch());
		
		Vector<Item> items_v2 = new Vector<Item>();
		Item item2 = new Item();
		item2.setTitle("2nd item");
		item2.setPrice(1000000);
		item2.setDate("Oct 31", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		item2.setUrl("www.youtube.com.hk");
		items_v.add(item2);
		List<Item> items2_l = items_v2;
		c.updateSearchListsTest(items2_l);
		assertEquals(items_l, c.getLastSearch());
	}
	
	/**
	 * tests terminate window
	 * @author imc4kmacpro
	 */
	@Test
	public void testTerminateWindow() {
		Controller c = new Controller();
		assertTrue(c.terminateWindow(null));
	}
}
