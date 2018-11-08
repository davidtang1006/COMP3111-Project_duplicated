package comp3111.webscraper;


import org.junit.Test;

import javafx.collections.ObservableList;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class ControllerTest {
	
	@Test
	public void testCreation() {
		Controller c = new Controller();
		assertNotNull(c);
	}
	
	@Test
	public void testGetList() {
		Controller c = new Controller();
		Vector<Item> items = new Vector<Item>();
		Item item = new Item();
		item.setTitle("haha");
		item.setPrice(3.333);
//		item.setUrl("https://google.com.hk");
						//Nov 8 new SimpleDateFormat("MMM dd", Locale.ENGLISH)
		item.setDate("Nov 8", new SimpleDateFormat("MMM dd", Locale.ENGLISH));
		items.add(item);
		List<Item> items_list = items;
		ObservableList<Item> oList = c.getListTest(items_list);
		assertNotNull(oList);
	}
}
