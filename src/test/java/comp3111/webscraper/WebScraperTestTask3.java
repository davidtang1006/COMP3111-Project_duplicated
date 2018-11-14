package comp3111.webscraper;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class WebScraperTestTask3 {
	
	
	/**
	 *	Test the method "getPagesCraigslist"
	 *	@author Benker 
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
		assertEquals(ls.size(), 1);
		
		// test two page
		ls = s.getPagesCraigslist(more_url);
		assertEquals(ls.size(), 2);
	}
	
	/**
	 *	Test the method "getPagesAmazon"
	 *	@author Benker 
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
		assertEquals(ls.size(), 1);
		
		// test two page
		ls = s.getPagesAmazon(more_url);
		assertEquals(ls.size(), 20);
		
		// test one page, exception
		ls = s.getPagesAmazon(exc_url);
		assertEquals(ls.size(), 1);
		
	}
	
	
}
