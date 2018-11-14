package comp3111.webscraper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import java.util.List;

// New imports, by ckchuad
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Date;
import java.util.Vector;

/**
 * This class manages GUI interaction
 * @author awtang, kevinw
 */

// Controller class that manage GUI interaction. Please see document about JavaFX for details.
public class Controller extends WebScraperApplication {
	@FXML
	private Label labelCount;

	@FXML
	private Label labelPrice;

	@FXML
	private Hyperlink labelMin;

	@FXML
	private Hyperlink labelLatest;

	@FXML
	private TextField textFieldKeyword;

	@FXML
	private TextArea textAreaConsole;

	private WebScraper scraper;

	// by awtang
	public List<Item> result = new Vector<Item>();
	public int item_count = 0;
	public int event_handler_count = 0;
	public int item_count_nonzero = 0;
	public double price_sum = 0;
	public double min_price = Double.POSITIVE_INFINITY;
	public String labelMin_url = "";
	public String labelLatest_title = "";
	public String labelLatest_url = "";
	public Date max_date = new Date(0L); // "0L" means the number zero of type "long"

	public int test_exit_value = 0; // for unit testing
	// end by awtang

	// by ckchuad, task 4
	@FXML
	private TableView<Item> table;

	@FXML
	private TableColumn<Item, String> labelTableTitle;

	@FXML
	private TableColumn<Item, Double> labelTablePrice;

	@FXML
	private TableColumn<Item, Hyperlink> labelTableURL;

	@FXML
	private TableColumn<Item, String> labelTableDate;

	private final HostServices host;
	// end by ckchuad, task 4

	/**
	 * Default controller
	 */
	public Controller() {
		scraper = new WebScraper();
		// by ckchuad, task 4
		host = this.getHostServices();
		// end by ckchuad, task 4
	}

	/**
	 * Default initializer. It is empty.
	 */
	@FXML
	private void initialize() {
	
	}

	/**
	 * Called when the search button is pressed. Used in task 1.
	 * @author awtang
	 */

	// (There is no @param, @return, @exception)
	@FXML
	private void actionSearch() {
		if (textFieldKeyword.getText().isEmpty()) {
			return; // Do nothing and return
		}
		
		// Fetch the result by the scraper
		System.out.println("actionSearch: " + textFieldKeyword.getText());
//		result = scraper.scrape(textFieldKeyword.getText());
		
		// added by Benker, for task3, removed scrape function
		String keyword = textFieldKeyword.getText().trim();
		int pageCount = 0;
		System.out.println("Start to get page");
		List<String> craigslistPages = scraper.getPagesCraigslist(keyword);
		List<String> amazonPages = scraper.getPagesAmazon(keyword);
		System.out.println("Finished get page");
		for (String page : craigslistPages) {
			result.addAll(scraper.scrapeCraigslist(page));
			textAreaConsole.appendText("Scraped " + (++pageCount) + " pages");
		}
		for (String page : amazonPages) {
			result.addAll(scraper.scrapeAmazon(page));
			textAreaConsole.appendText("Scraped " + (++pageCount) + " pages");
		}
		// end task3
		
		
		getItemsAndDisplay(false);
	}
	
	/**
	 * Get the items from the object "result" and display them. Used in task 1.
	 * @author awtang
	 * @param test_mode set this to true when running unit tests
	 */
	public void getItemsAndDisplay(boolean test_mode) {
		String output = "";
		item_count = result.size();
		
		if (event_handler_count == 0 && test_mode == false) {
			// The event handler is added once only
			labelMin.addEventHandler(ActionEvent.ACTION, (e) -> openDoc(labelMin_url));
			labelLatest.addEventHandler(ActionEvent.ACTION, (e) -> openDoc(labelLatest_url));
			event_handler_count++;
		}
		
		if(item_count >= 1) {
			labelLatest_title = result.get(0).getTitle(); // The first result
			labelLatest_url = result.get(0).getUrl(); // The first result
			
			for (Item item : result) {
				// We print the scraped data in the console tab
				output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
				
				if (item.getPrice() != 0.0) {
					// Items with zero selling price is excluded in the calculations
					item_count_nonzero += 1;
					price_sum += item.getPrice(); // To calculate the average selling price
					
					// Find the item with lowest selling price
					if (item.getPrice() < min_price) {
						min_price = item.getPrice();
						// Set the URL for labelMin_url
						labelMin_url = item.getUrl();
					}
				}
				
				// Find the latest post
				if (item.getDate_raw() != null) {
					if (item.getDate_raw().compareTo(max_date) > 0) {
						max_date = item.getDate_raw();
						labelLatest_title = item.getTitle();
						labelLatest_url = item.getUrl();
					}
				}
			}
			
			if (item_count_nonzero != 0) { // At least one item has a price
				test_exit_value = 1;
				if (test_mode == false) {
					labelPrice.setText(Double.toString(price_sum/item_count_nonzero));
					labelMin.setText(Double.toString(min_price));
				}
			} else { // All the items have no prices
				test_exit_value = 2;
				if (test_mode == false) {
					labelMin_url = "";
					labelPrice.setText("-");
					labelMin.setText("-");
				}
			}
			if (test_mode == false) {
				textAreaConsole.setText(output);
				labelCount.setText(Integer.toString(item_count));
				labelLatest.setText(labelLatest_title);
			}
		} else { // We cannot find a result
			test_exit_value = 3;
			if (test_mode == false) {
				// We refresh the contents for another search
				labelMin_url = "";
				labelLatest_url = "";
				
				textAreaConsole.setText(output);
				labelCount.setText("0");
				labelPrice.setText("-");
				labelMin.setText("-");
				labelLatest.setText("-");
			}
		}
	}
	
	// hyperlink helper function
	/**
	 * used in task 1<br>
	 * opens the url specified in url in a new browser window<br>
	 * call method:<br>
	 * item.getUrl().addEventHandler(ActionEvent.ACTION, (e) -&gt; openDoc(item.getUrlText()));<br>
	 * or<br>
	 * openDoc(label.getText());
	 * @author ckchuad, awtang
	 * @param url the URL string one wants to open in the browser
	 */
	public void openDoc(String url) {
		if (url != "") {
			host.showDocument(url);
		}
	}
	
	/**
	 * Called when the new button is pressed. Very dummy action - print something in the command prompt.
	 */
	@FXML
	private void actionNew() {
		System.out.println("actionNew");
	}
}