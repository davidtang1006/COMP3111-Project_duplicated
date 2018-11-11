package comp3111.webscraper;

// New imports, by awtang
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class is for testing the class "Controller"
 * @author awtang
 */
public class ControllerTest {
	private Controller c = new Controller();
	
	/**
	 * We have 3 items with a price in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay1() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item(true);
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		c.result.add(i_1);
		
		// The second item
		Item i_2 = new Item(true);
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Craigslist");
		i_2.setPrice(2.0);
		i_2.setTitle("Banana");
		c.result.add(i_2);
		
		// The third item
		Item i_3 = new Item(true);
		i_3.setDate("January 3, 2018", df);
		i_3.setPortal("Amazon");
		i_3.setPrice(3.0);
		i_3.setTitle("Cherry");
		c.result.add(i_3);
		
		c.getItemsAndDisplay(true);
		assertEquals(3, c.item_count);
		assertEquals(3, c.item_count_nonzero);
		assertEquals(6, c.price_sum, 0);
		assertEquals(1, c.min_price, 0);
		assertEquals("Cherry", c.labelLatest_title);
		Date expected_date = null;
		try {
			expected_date = df.parse("January 3, 2018");
		}
		catch(ParseException e) {
			System.out.println(e.toString());
			expected_date = null;
		}
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(1, c.test_exit_value);
	}
	
	/**
	 * We have 3 items with no prices in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay2() {
		// The first item
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item(true);
		i_1.setDate("January 2, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(0.0);
		i_1.setTitle("Apple");
		c.result.add(i_1);
		
		// The second item
		Item i_2 = new Item(true);
		i_2.setDate("January 1, 2018", df);
		i_2.setPortal("Craigslist");
		i_2.setPrice(0.0);
		i_2.setTitle("Banana");
		c.result.add(i_2);
		
		// The third item
		Item i_3 = new Item(true);
		i_3.setDate("January 3, 2018", df);
		i_3.setPortal("Amazon");
		i_3.setPrice(0.0);
		i_3.setTitle("Cherry");
		c.result.add(i_3);
		
		c.getItemsAndDisplay(true);
		assertEquals(3, c.item_count);
		assertEquals(0, c.item_count_nonzero);
		assertEquals(0, c.price_sum, 0);
		assertEquals(Double.POSITIVE_INFINITY, c.min_price, 0);
		assertEquals("Cherry", c.labelLatest_title);
		Date expected_date = null;
		try {
			expected_date = df.parse("January 3, 2018");
		}
		catch(ParseException e) {
			System.out.println(e.toString());
			expected_date = null;
		}
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(2, c.test_exit_value);
	}
	
	/**
	 * We have 1 item with a price in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay3() {
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item(true);
		i_1.setDate("January 1, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(1.0);
		i_1.setTitle("Apple");
		c.result.add(i_1);
		
		c.getItemsAndDisplay(true);
		assertEquals(1, c.item_count);
		assertEquals(1, c.item_count_nonzero);
		assertEquals(1, c.price_sum, 0);
		assertEquals(1, c.min_price, 0);
		assertEquals("Apple", c.labelLatest_title);
		Date expected_date = null;
		try {
			expected_date = df.parse("January 1, 2018");
		}
		catch(ParseException e) {
			System.out.println(e.toString());
			expected_date = null;
		}
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(1, c.test_exit_value);
	}
	
	/**
	 * We have 1 item with no prices in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay4() {
		DateFormat df = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		Item i_1 = new Item(true);
		i_1.setDate("January 1, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(0.0);
		i_1.setTitle("Apple");
		c.result.add(i_1);
		
		c.getItemsAndDisplay(true);
		assertEquals(1, c.item_count);
		assertEquals(0, c.item_count_nonzero);
		assertEquals(0, c.price_sum, 0);
		assertEquals(Double.POSITIVE_INFINITY, c.min_price, 0);
		assertEquals("Apple", c.labelLatest_title);
		Date expected_date = null;
		try {
			expected_date = df.parse("January 1, 2018");
		}
		catch(ParseException e) {
			System.out.println(e.toString());
			expected_date = null;
		}
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(2, c.test_exit_value);
	}
	
	/**
	 * We have 1 item with no date in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay5() {
		Item i_1 = new Item(true);
		//i_1.setDate("January 1, 2018", df);
		i_1.setPortal("Amazon");
		i_1.setPrice(0.0);
		i_1.setTitle("Apple");
		c.result.add(i_1);
		
		c.getItemsAndDisplay(true);
		assertEquals(1, c.item_count);
		assertEquals(0, c.item_count_nonzero);
		assertEquals(0, c.price_sum, 0);
		assertEquals(Double.POSITIVE_INFINITY, c.min_price, 0);
		assertEquals("Apple", c.labelLatest_title);
		Date expected_date = new Date(0L);
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(2, c.test_exit_value);
	}
	
	/**
	 * We have 0 items in this case
	 * @author awtang
	 */
	@Test
	public void testGetItemsAndDisplay6() {
		c.getItemsAndDisplay(true);
		assertEquals(0, c.item_count);
		assertEquals(0, c.item_count_nonzero);
		assertEquals(0, c.price_sum, 0);
		assertEquals(Double.POSITIVE_INFINITY, c.min_price, 0);
		assertEquals("", c.labelLatest_title);
		Date expected_date = new Date(0L);
		assertTrue(expected_date.equals(c.max_date));
		assertEquals(3, c.test_exit_value);
	}
	
	/**
	 * We test "openDoc" method by passing "" and then "https://www.google.com.hk/" to it
	 * @author awtang
	 */
	@Test
	public void testOpenDoc() {
		c.openDoc("");
		c.openDoc("https://www.google.com.hk/");
	}
}
