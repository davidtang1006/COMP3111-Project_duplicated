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
	 *	@author lyleungad
	 */
	@Test
	public void testGetPagesCraigslist() {
		WebScraper s = new WebScraper();
		
		// one page url
		String one_url = "https://newyork.craigslist.org/search/sss?query=whatisthisthingshouldbenothing&sort=rel";
		// 8 page url
		String more_url = "https://newyork.craigslist.org/search/sss?query=galaxy%20s9&sort=rel";
		List<String> ls = s.getPagesCraigslist(one_url);
		
		// test one page, including no page
		assertEquals(1, ls.size());
		
		// test two page
		ls = s.getPagesCraigslist(more_url);
		assertEquals(2, ls.size());
	}
	
	/**
	 *	Test the method "getPagesAmazon"
	 *	@author lyleungad
	 */
	@Test
	public void testGetPagesAmazon() {
		WebScraper s = new WebScraper();
		
		// one page url
		String one_url = "https://www.amazon.com/s/ref=sr_st_date-desc-rank?keywords=whatisthisthisisnothing&sort=date-desc-rank";
		// 20 page url
		String more_url = "https://www.amazon.com/s/ref=sr_st_date-desc-rank?keywords=haha&sort=date-desc-rank";
		List<String> ls = s.getPagesAmazon(one_url);
		
		// exception one page
		String exc_url = "https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=whatisthisar&rh=i%3Aaps%2Ck%3Awhatisthisar";
		
		// test one page, including no page
		assertEquals(1, ls.size());
		
		// test two pages
		ls = s.getPagesAmazon(more_url);
		assertEquals(20, ls.size());
		
		// test one page, exception
		ls = s.getPagesAmazon(exc_url);
		assertEquals(1, ls.size());
	}
}
