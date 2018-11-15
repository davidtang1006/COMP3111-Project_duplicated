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
		Controller c = new Controller();
		c.initGUIObjs();
		assertTrue(true);
	}
	/**
	 * tests opening empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocNotEmpty() {
		Controller c = new Controller();
		c.initGUIObjs();
		c.openDoc("https://www.google.com.hk/");
	}
	
	/**
	 * tests opening non-empty string using openDoc()
	 * @author awtang
	 */
	@Test
	public void testOpenDocEmpty() {
		Controller c = new Controller();
		c.initGUIObjs();
		c.openDoc("");
	}
	
	/**
	 * tests scraper: has result
	 * @author imc4kmacpro
	 */
	@Test
	public void testScraperNotEmpty() {
		Controller c = new Controller();
		c.initGUIObjs();
		List<Item> list = c.getScraper().scrape("galaxy s10 r3");
		assertNotNull(list);
	}
	
	/**
	 * tests scraper: has no result
	 * @author imc4kmacpro
	 */
	@Test
	public void testScraperEmpty() {
		Controller c = new Controller();
		c.initGUIObjs();
		List<Item> list = c.getScraper().scrape("galaxy s10 1 fl 4 v");
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testActionSearch() {
		Controller c = new Controller();
		c.initGUIObjs();
		List<Item> list = c.actionSearchTest("galaxy s10 r3");
		assertTrue(!list.isEmpty());
	}
}
