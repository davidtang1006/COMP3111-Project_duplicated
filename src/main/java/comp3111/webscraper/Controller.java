/**
 * 
 */
package comp3111.webscraper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.Date;
import java.util.List;

/**
 * @author awtang, kevinw
 */

// Controller class that manage GUI interaction. Please see document about JavaFX for details.
public class Controller extends Application {
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

	String labelMin_url = ""; // added by awtang
	
	String labelLatest_url = ""; // added by awtang

	
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
	 * @author awtang
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
    @Override
    public void start(Stage Stage) {
    	
    };
	
	/**
	 * Called when the search button is pressed.
	 *
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
		double price_sum = 0;
		double min_price = Double.POSITIVE_INFINITY;
		String labelLatest_title = "";
		Date max_date = null;

		if(item_count >= 1) {
			labelLatest_title = result.get(0).getTitle(); // The first result
			labelLatest_url = result.get(0).getUrlText(); // The first result
			
			for (Item item : result) {
				output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
				price_sum += item.getPrice(); // To calculate the average selling price
				
				// Find the item with lowest selling price
				if (item.getPrice() < min_price) {
					min_price = item.getPrice();
					// Set the URL for labelMin_url
					labelMin_url = item.getUrlText();
				}
				
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
			labelPrice.setText(Double.toString(price_sum/item_count));
			labelMin.setText(Double.toString(min_price));
			labelMin.setOnAction(labelMin_clickHandler);
			labelLatest.setText(labelLatest_title);
			labelLatest.setOnAction(labelLatest_clickHandler);
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

	/**
	 * @author awtang
	 */
	EventHandler<ActionEvent> labelMin_clickHandler = new EventHandler<ActionEvent>() {  
		@Override
		public void handle(ActionEvent event) {
			if (labelMin_url != "") {
				getHostServices().showDocument(labelMin_url);
			}
		}
	};

	/**
	 * @author awtang
	 */
	EventHandler<ActionEvent> labelLatest_clickHandler = new EventHandler<ActionEvent>() {  
		@Override
		public void handle(ActionEvent event) {
			if (labelMin_url != "") {
				getHostServices().showDocument(labelLatest_url);
			}
		}
	};
	
	/**
	 * Called when the new button is pressed. Very dummy action - print something in the command prompt.
	 */
	@FXML
	private void actionNew() {
		System.out.println("actionNew");
	}
}