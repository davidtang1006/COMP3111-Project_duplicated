package comp3111.webscraper;

// New imports, by awtang
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This class is for testing the class "ItemComparator"
 * @author awtang
 */
public class ItemComparatorTest {
	private ItemComparator ic = new ItemComparator();
	
	/**
	 * We have 2 items with different prices in this case
	 * @author awtang
	 */
	@Test
	public void testCompare1() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item();
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		
		// The second item
		Item i_2 = new Item();
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Craigslist");
		i_2.setPrice(2.0);
		i_2.setTitle("Banana");
		
		assertEquals(-1, ic.compare(i_1, i_2));
	}
	
	/**
	 * We have 2 items of the same price, 
	 * with first one from Amazon, and second one from Craigslist in this case
	 * @author awtang
	 */
	@Test
	public void testCompare2() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item();
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		
		// The second item
		Item i_2 = new Item();
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Craigslist");
		i_2.setPrice(1.0);
		i_2.setTitle("Banana");
		
		assertEquals(1, ic.compare(i_1, i_2));
	}
	
	/**
	 * We have 2 items of the same price, 
	 * with first one from Craigslist, and second one from Amazon in this case
	 * @author awtang
	 */
	@Test
	public void testCompare3() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item();
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Craigslist");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		
		// The second item
		Item i_2 = new Item();
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Amazon");
		i_2.setPrice(1.0);
		i_2.setTitle("Banana");
		
		assertEquals(-1, ic.compare(i_1, i_2));
	}
	
	/**
	 * We have 2 items of the same price from Amazon in this case
	 * @author awtang
	 */
	@Test
	public void testCompare4() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item();
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		
		// The second item
		Item i_2 = new Item();
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Amazon");
		i_2.setPrice(1.0);
		i_2.setTitle("Banana");
		
		assertEquals(0, ic.compare(i_1, i_2));
	}
	
	/**
	 * We have 2 items of the same price from Craigslist in this case
	 * @author awtang
	 */
	@Test
	public void testCompare5() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item();
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Craigslist");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		
		// The second item
		Item i_2 = new Item();
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Craigslist");
		i_2.setPrice(1.0);
		i_2.setTitle("Banana");
		
		assertEquals(0, ic.compare(i_1, i_2));
	}
}
