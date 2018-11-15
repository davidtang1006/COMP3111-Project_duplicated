package comp3111.webscraper;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * this class tests the overall functionalities of controller,
 * methods that is not written by specific team mate
 * @author imc4kmacpro
 *
 */
public class IntegrationTest {
	WebScraperApplication a = new WebScraperApplication();
	Controller c = new Controller();
	
	/**
	 * tests creation of controller
	 * @author imc4kmacpro
	 */
	@Test
	public void testControllerCreation() {
		Controller c = new Controller();
		assertNotNull(c);
	}
	
	/**
	 * tests initialization of GUI objects
	 */
	@Test
	public void testInitGUIObjs() {
		c.initGUIObjs();
		assertTrue(true);
	}
	/**
	 * tests opening empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocNotEmpty() {
		c.openDocTest("https://www.google.com.hk/");
	}
	
	/**
	 * tests opening non-empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocEmpty() {
		c.openDocTest("");
	}
	
	/**
	 * tests scraper: has result
	 * @author imc4kmacpro
	 */
	@Test
	public void testScraperNotEmpty() {
		List<Item> list = c.getScraper().scrape("iphone");
		assertNotNull(list);
	}
	
	/**
	 * tests scraper: has no result
	 * @author imc4kmacpro
	 */
	@Test
	public void testScraperEmpty() {
		List<Item> list = c.getScraper().scrape("galaxy s10 1 fl 4 v");
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testActionSearch() {
		c.initGUIObjs();
		List<Item> list = c.actionSearchTest("iphone");
		assertTrue(!list.isEmpty());
	}
}
