package comp3111.webscraper;

import java.io.File;
import java.net.MalformedURLException;
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

	}
	
	/**
	 *	Test the method "getPagesAmazon"
	 * @author Benker
	 * @throws Exception
	 */
	@Test
	public void testGetPagesAmazon() throws Exception {
		WebScraper s = new WebScraper();	
		// 3 pages
		String path = new File("").getAbsolutePath().toString() + "\\src\\main\\resources\\amazonPages_Task3\\amazonTest1.html";
		String fileUrl = new File(path).toURI().toURL().toString();
		List<String> pages = s.getPagesAmazon(fileUrl);
		System.out.println(pages.size());
		assertEquals(pages.size(), 3);
		
		// 1 page
		path = path.substring(0, path.lastIndexOf('\\')) + "\\amazonTest3.html";
		fileUrl = new File(path).toURI().toURL().toString();
		pages = s.getPagesAmazon(fileUrl);
		System.out.println(pages.size());
		assertEquals(pages.size(), 1);
		
		
	}
}
