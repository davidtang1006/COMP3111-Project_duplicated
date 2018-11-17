package comp3111.webscraper;

// New imports by awtang
import java.net.URLEncoder;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is for testing the class "WebScraper"
 * @author awtang
 */
public class WebScraperTestTask2 {
	private WebScraper ws = new WebScraper();
	private static final String url_string_1 = "https://newyork.craigslist.org/search/sss?sort=rel&query=";
	private static final String url_string_2 = "https://www.amazon.com/s/ref=sr_st_date-desc-rank?keywords=";
	private static final String url_string_3 = "&sort=date-desc-rank";
	
	/**
	 * Test the method "scrapeCraigslist". Multiple keywords are tested.
	 * @author awtang
	 */
	@Test
	public void testScrapeCraigslist() {
		try {
			assertFalse(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("apple", "UTF-8")).isEmpty());
			assertFalse(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("bag", "UTF-8")).isEmpty());
			assertFalse(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("ball", "UTF-8")).isEmpty());
			assertFalse(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("calculator", "UTF-8")).isEmpty());
			assertFalse(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("chair", "UTF-8")).isEmpty());
			
			assertTrue(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("cwLfnfzoBcCGlGdZneyP", "UTF-8")).isEmpty()); // There should be no results
			assertTrue(ws.scrapeCraigslist(url_string_1 + URLEncoder.encode("LCPKqiZqgIBAISHncpPC", "UTF-8")).isEmpty()); // There should be no results
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Test the method "scrapeAmazon". Multiple keywords are tested.
	 * @author awtang
	 */
	@Test
	public void testScrapeAmazon() {
		try {
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("apple", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("bag", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("ball", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("calculator", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("chair", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("diamond", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("g-shock", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("gta5", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("harry potter", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("inception", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("iphone", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("jewelry", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("microsoft office", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("minecraft", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("pen", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("pineapple", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("samsung", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("sony", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("superman", "UTF-8") + url_string_3).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("watch", "UTF-8") + url_string_3).isEmpty());
		
		assertTrue(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("cwLfnfzoBcCGlGdZneyP", "UTF-8") + url_string_3).isEmpty()); // There should be no results
		assertTrue(ws.scrapeAmazon(url_string_2 + URLEncoder.encode("LCPKqiZqgIBAISHncpPC", "UTF-8") + url_string_3).isEmpty()); // There should be no results
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}