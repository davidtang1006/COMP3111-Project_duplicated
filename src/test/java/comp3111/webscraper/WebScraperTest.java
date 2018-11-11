package comp3111.webscraper;

// New imports by awtang
import org.junit.Test;

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
		ws.scrapeAmazon("apple", true);
		ws.scrapeAmazon("bag", true);
		ws.scrapeAmazon("ball", true);
		ws.scrapeAmazon("calculator", true);
		ws.scrapeAmazon("chair", true);
		ws.scrapeAmazon("diamond", true);
		ws.scrapeAmazon("g-shock", true);
		ws.scrapeAmazon("gta5", true);
		ws.scrapeAmazon("harry potter", true);
		ws.scrapeAmazon("inception", true);
		ws.scrapeAmazon("iphone", true);
		ws.scrapeAmazon("jewelry", true);
		ws.scrapeAmazon("microsoft office", true);
		ws.scrapeAmazon("minecraft", true);
		ws.scrapeAmazon("pen", true);
		ws.scrapeAmazon("pineapple", true);
		ws.scrapeAmazon("samsung", true);
		ws.scrapeAmazon("sony", true);
		ws.scrapeAmazon("superman", true);
		ws.scrapeAmazon("watch", true);
		
		ws.scrapeAmazon("cwLfnfzoBcCGlGdZneyP", true); // There should be no results
		ws.scrapeAmazon("LCPKqiZqgIBAISHncpPC", true); // There should be no results
	}
}