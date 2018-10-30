/**
 * 
 */
package comp3111.webscraper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import java.util.List;

/**
 * @author awtang, kevinw
 *
 * Controller class that manage GUI interaction. Please see document about JavaFX for details.
 */
public class Controller {

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
	
	/**
	 * Default controller
	 */
	public Controller() {
		scraper = new WebScraper();
	}

	/**
	 * Default initializer. It is empty.
	 */
	@FXML
	private void initialize() {
	
	}
	
	/**
	 * Called when the search button is pressed.
	 *
	 * @author awtang
	 *
	 * (There is no @param, @return or @exception)
	 */
	@FXML
	private void actionSearch() {
		// Fetch the result by the scraper
		System.out.println("actionSearch: " + textFieldKeyword.getText());
		List<Item> result = scraper.scrape(textFieldKeyword.getText());
		
		String output = "";
		int item_count = result.size();
		double price_sum = 0;
		double min_price = Double.POSITIVE_INFINITY;
		String labelMin_url = "";

		if(item_count > 1) {
			for (Item item : result) {
				output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
				price_sum += item.getPrice();
				if (item.getPrice() < min_price) {
					min_price = item.getPrice();
					// Set the URL for labelMin_url
					labelMin_url = item.getUrl();
				}
			}
			textAreaConsole.setText(output);
			labelCount.setText(Integer.toString(item_count));
			labelPrice.setText(Double.toString(price_sum/item_count));
			labelMin.setText(Double.toString(min_price));
			System.out.println(labelMin_url);
			labelLatest.setText("-");
		} else { // We cannot find a result
			textAreaConsole.setText(output);
			labelCount.setText("-");
			labelPrice.setText("-");
			labelMin.setText("-");
			labelLatest.setText("-");
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