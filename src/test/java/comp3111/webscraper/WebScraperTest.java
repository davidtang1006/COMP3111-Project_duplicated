package comp3111.webscraper;

// New imports by awtang
import java.net.URLEncoder;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class is for testing the class "WebScraper"
 * @author awtang
 */
public class WebScraperTest {
	private WebScraper ws = new WebScraper();
	private static final String url_string_1 = "https://www.amazon.com/s/ref=sr_st_date-desc-rank?keywords=";
	private static final String url_string_2 = "&sort=date-desc-rank";
	
	/**
	 * Test the method "scrapeAmazon". Multiple keywords are tested.
	 * @author awtang
	 */
	@Test
	public void testScrapeAmazon() {
		try {
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("apple", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("bag", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("ball", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("calculator", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("chair", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("diamond", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("g-shock", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("gta5", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("harry potter", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("inception", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("iphone", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("jewelry", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("microsoft office", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("minecraft", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("pen", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("pineapple", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("samsung", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("sony", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("superman", "UTF-8") + url_string_2).isEmpty());
		assertFalse(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("watch", "UTF-8") + url_string_2).isEmpty());
		
		assertTrue(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("cwLfnfzoBcCGlGdZneyP", "UTF-8") + url_string_2).isEmpty()); // There should be no results
		assertTrue(ws.scrapeAmazon(url_string_1 + URLEncoder.encode("LCPKqiZqgIBAISHncpPC", "UTF-8") + url_string_2).isEmpty()); // There should be no results
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}