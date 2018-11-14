package comp3111.webscraper;

import org.junit.Test;
import static org.junit.Assert.*;

public class WebScraperApplicationTest {
	
	/**
	 * tests creation of application
	 * note: has to close the application manually to resume running the test
	 * @author imc4kmacpro
	 */
	@Test
	public void testWebScrapperApplicationCreation() {
		WebScraperApplication a = new WebScraperApplication();
		a.main(null);
		assertNotNull(a);
	}
}
