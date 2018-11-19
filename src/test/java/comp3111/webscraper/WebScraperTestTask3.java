package comp3111.webscraper;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is for testing the methods in class "WebScraper" used in task 3
 * @author lyleungad
 */
public class WebScraperTestTask3 {
	
	/**
	 *	Test the method "getPagesCraigslist"
	 * @author Benker
	 */
	@Test
	public void testGetPagesCraigslist() {
		WebScraper s = new WebScraper();
		
		// one page url
		String one_url = "whatisthisthingshouldbenothing";
		// two pages url
		String more_url = "galaxy s9";
		// exception one page
		String exc_url = "cfker";
		
		// test one page, including no page
		List<String> ls = s.getPagesCraigslist(one_url);
		assertEquals(1, ls.size());
		
		// test two page
		ls = s.getPagesCraigslist(more_url);
		assertEquals(2, ls.size());
		
		// exception no items
		ls = s.getPagesCraigslist(exc_url);
		assertEquals(1, ls.size());
		
	}
	
	/**
	 *	Test the method "getPagesAmazon"
	 * @author Benker
	 */
	@Test
	public void testGetPagesAmazon() {
		WebScraper s = new WebScraper();
		
		// one page url
		String one_url = "whatisthisthisisnothing";
		// 3 page url
		String more_url = "galaxy s10 r3";		
		// exception one page
		String exc_url = "whatisthisar";
		
		// test one page, including no page
		List<String> ls = s.getPagesAmazon(one_url);
		assertEquals(1, ls.size());
		
		// test three pages
		ls = s.getPagesAmazon(more_url);
		assertEquals(3, ls.size());
		
		// test one page, exception (no item)
		ls = s.getPagesAmazon(exc_url);
		assertEquals(1, ls.size());
	}
}
