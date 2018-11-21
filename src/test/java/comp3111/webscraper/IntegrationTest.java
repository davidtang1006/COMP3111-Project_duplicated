package comp3111.webscraper;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * this class tests the overall functionalities of controller<br>
 * methods that is not written by other teammates
 * @author ckchuad, awtang
 */
public class IntegrationTest {
	/**
	 * tests creation of controller
	 * @author ckchuad
	 */
	@Test
	public void testControllerCreation() {
		Controller c = new Controller();
		assertNotNull(c);
	}
	
	/**
	 * tests opening empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocNotEmpty() {
		Controller c = new Controller();
		c.openDoc("https://www.google.com.hk/");
	}
	
	/**
	 * tests opening non-empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocEmpty() {
		Controller c = new Controller();
		c.openDoc("");
	}
	
	/**
	 * tests scraper: has result
	 * @author ckchuad
	 */
	@Test
	public void testScraperNotEmpty() {
		Controller c = new Controller();
		List<Item> list = c.getScraper().scrape("galaxy s10 r3");
		assertNotNull(list);
	}
	
	/**
	 * tests scraper: has no result
	 * @author ckchuad
	 */
	@Test
	public void testScraperEmpty() {
		Controller c = new Controller();
		List<Item> list = c.getScraper().scrape("galaxy s10 1 fl 4 v");
		assertTrue(list.isEmpty());
	}
}
