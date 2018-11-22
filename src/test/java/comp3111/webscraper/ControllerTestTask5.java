package comp3111.webscraper;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTestTask5 {
	/**
	 * 	Test the method "refineSearch"
	 * 
	 * @author lyleungad
	 */	
	@Test
	public void testRefineSearch() {
		// prepare the test param
    	List<Item> currSearch = new ArrayList<Item>();
    	for (int i = 0; i < 3; i++) {
			Item item = new Item();
			item.setTitle("Here is Iphone");
			currSearch.add(item);
		}
    	Item a = new Item();
    	a.setTitle("Here is IphoneX");
    	currSearch.add(a);
    	
    	Controller c = new Controller();
    	String filter = "IphoneX";
    	
    	// after filtering, item size should be 1
    	assertEquals(1, c.testRefineSearch(currSearch, filter));
	}
}
