package comp3111.webscraper;

// New imports by awtang
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is for testing the class "WebScraper"
 * @author awtang
 */
public class WebScraperTest {
	private WebScraper ws = new WebScraper();
	
	/**
	 * Test the method "scrapeAmazon". Multiple keywords are tested.
	 * @author awtang
	 */
	@Test
	public void testScrapeAmazon() {
		assertFalse(ws.scrapeAmazon("apple").isEmpty());
		assertFalse(ws.scrapeAmazon("bag").isEmpty());
		assertFalse(ws.scrapeAmazon("ball").isEmpty());
		assertFalse(ws.scrapeAmazon("calculator").isEmpty());
		assertFalse(ws.scrapeAmazon("chair").isEmpty());
		assertFalse(ws.scrapeAmazon("diamond").isEmpty());
		assertFalse(ws.scrapeAmazon("g-shock").isEmpty());
		assertFalse(ws.scrapeAmazon("gta5").isEmpty());
		assertFalse(ws.scrapeAmazon("harry potter").isEmpty());
		assertFalse(ws.scrapeAmazon("inception").isEmpty());
		assertFalse(ws.scrapeAmazon("iphone").isEmpty());
		assertFalse(ws.scrapeAmazon("jewelry").isEmpty());
		assertFalse(ws.scrapeAmazon("microsoft office").isEmpty());
		assertFalse(ws.scrapeAmazon("minecraft").isEmpty());
		assertFalse(ws.scrapeAmazon("pen").isEmpty());
		assertFalse(ws.scrapeAmazon("pineapple").isEmpty());
		assertFalse(ws.scrapeAmazon("samsung").isEmpty());
		assertFalse(ws.scrapeAmazon("sony").isEmpty());
		assertFalse(ws.scrapeAmazon("superman").isEmpty());
		assertFalse(ws.scrapeAmazon("watch").isEmpty());
		
		assertTrue(ws.scrapeAmazon("cwLfnfzoBcCGlGdZneyP").isEmpty()); // There should be no results
		assertTrue(ws.scrapeAmazon("LCPKqiZqgIBAISHncpPC").isEmpty()); // There should be no results
	}
}