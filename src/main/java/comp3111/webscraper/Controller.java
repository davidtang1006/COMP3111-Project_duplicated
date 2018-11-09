package comp3111.webscraper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;

// New imports, by ckchaud
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Date;
import java.util.List;

/**
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

	private String labelMin_url = ""; // added by awtang

	private String labelLatest_url = ""; // added by awtang

	// by ckchaud, task 4
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
	// end by ckchaud, task 4

	/**
	 * Default controller
	 */
	public Controller() {
		scraper = new WebScraper();
		// by ckchaud, task 4
		host = this.getHostServices();
		// end by ckchaud, task 4
	}

	/**
	 * Default initializer. It is empty.
	 */
	@FXML
	private void initialize() {
	
	}

	/**
	 * Called when the search button is pressed.
	 * @author awtang
	 */

	// (There is no @param, @return or @exception)
	@FXML
	private void actionSearch() {
		if (textFieldKeyword.getText().isEmpty()) {
			return; // Do nothing and return
		}
				
		// Fetch the result by the scraper
		System.out.println("actionSearch: " + textFieldKeyword.getText());
		List<Item> result = scraper.scrape(textFieldKeyword.getText());
		
		String output = "";
		int item_count = result.size();
		int item_count_nonzero = 0;
		double price_sum = 0;
		double min_price = Double.POSITIVE_INFINITY;
		String labelLatest_title = "";
		Date max_date = new Date(0L); // "0L" means the number zero of type "long"
		
		getItemsAndDisplay(item_count, result, output, item_count_nonzero,
				price_sum, min_price, max_date, labelLatest_title);
	}
	
	/**
	 * @author awtang
	 */
	public void getItemsAndDisplay(int item_count, List<Item> result, String output, int item_count_nonzero,
			double price_sum, double min_price, Date max_date, String labelLatest_title) {
		if(item_count >= 1) {
			labelLatest_title = result.get(0).getTitle(); // The first result
			labelLatest_url = result.get(0).getUrlText(); // The first result
			
			for (Item item : result) {
				output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
				
				if (item.getPrice() != 0.0) {
					// Items with zero selling price is excluded in the calculations
					item_count_nonzero += 1;
					price_sum += item.getPrice(); // To calculate the average selling price
					
					// Find the item with lowest selling price
					if (item.getPrice() < min_price) {
						min_price = item.getPrice();
						// Set the URL for labelMin_url
						labelMin_url = item.getUrlText();
					}
				}
				
				// Find the latest post
				if (item.getDate_raw() != null) {
					if (item.getDate_raw().compareTo(max_date) > 0) {
						max_date = item.getDate_raw();
						labelLatest_title = item.getTitle();
						labelLatest_url = item.getUrlText();
					}
				}
			}
			
			textAreaConsole.setText(output);
			labelCount.setText(Integer.toString(item_count));
			if (item_count_nonzero != 0) {
				labelPrice.setText(Double.toString(price_sum/item_count_nonzero));
				labelMin.setText(Double.toString(min_price));
			} else {
				labelMin_url = "";
				labelPrice.setText("-");
				labelMin.setText("-");
			}
			labelMin.addEventHandler(ActionEvent.ACTION, (e) -> openDoc(labelMin_url));
			labelLatest.setText(labelLatest_title);
			labelLatest.addEventHandler(ActionEvent.ACTION, (e) -> openDoc(labelLatest_url));
		} else { // We cannot find a result
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
	
	// by ckchaud, hyperlink helper function
	/**
	 * opens the url specified in url in a new browser window
	 * <br>
	 * call method:
	 * <br>
	 * item.getUrl().addEventHandler(ActionEvent.ACTION, (e) -> openDoc(item.getUrlText()));
	 * <br>
	 * or
	 * <br>
	 * openDoc(label.getText());
	 * @author ckchaud
	 * @param url
	 */
	private void openDoc(String url) {
		host.showDocument(url);
	}
	
	/**
	 * Called when the new button is pressed. Very dummy action - print something in the command prompt.
	 */
	@FXML
	private void actionNew() {
		System.out.println("actionNew");
	}
}