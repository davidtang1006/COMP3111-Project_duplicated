package comp3111.webscraper;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

public class ControllerTest {
	
	@Test
	public void testGetList() {
		Controller c = new Controller();
		Vector<Item> items = new Vector<Item>();
		for(int i = 0; i < 2; i++) {
			Item item = new Item();
			item.setTitle("item" + i);
			item.setDate(null, null);
			item.setPrice(i + 30);
			item.setUrl("https://google.com.hk");
			items.add(item);
		}
		List<Item> items_list = items;
		assertNotNull(c.getList(items_list));
	}
	
	@Test
	public void testCreateTable() {
		Controller c = new Controller();
		Vector<Item> items = new Vector<Item>();
		for(int i = 0; i < 2; i++) {
			Item item = new Item();
			item.setTitle("item" + i);
			item.setDate(null, null);
			item.setPrice(i + 30);
			item.setUrl("https://google.com.hk");
			items.add(item);
		}
		List<Item> items_list = items;
		c.createTable(items_list);
		// ???
	}
}
