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
	 * tests scraper
	 * @author imc4kmacpro
	 */
	@Test
	public void testScraper() {
		List<Item> list = c.getScraper().scrape("iphone");
		assertNotNull(list);
	}
}
