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

// added by Benker for task5
import java.util.function.Predicate;
import java.util.ArrayList;
// end task5

/**
 * 
 * @author kevinw
 *
 *
 * Controller class that manage GUI interaction. Please see document about JavaFX for details.
 * 
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
    	// added by Benker for task5
//    	 refineButton.setDisable(true);
    	// ended task5
    }
    
    /**
     * Called when the search button is pressed.
     */
    @FXML
    private void actionSearch() {
    	System.out.println("actionSearch: " + textFieldKeyword.getText());
    	List<Item> result = scraper.scrape(textFieldKeyword.getText());
    	String output = "";
    	for (Item item : result) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
    	}
    	textAreaConsole.setText(output);
    	
    	labelCount.setText("hi"); 
    	
    	// added by Benker for task5
    	// set refine button disable to fasle after search
//    	if(result.size()>0) {
//    		refineButton.setDisable(fasle);
//    	}
    	// end task5
    }
    
    /**
     * Called when the new button is pressed. Very dummy action - print something in the command prompt.
     */
    @FXML
    private void actionNew() {
    	System.out.println("actionNew");
    }
    
    
    /**
     *	This function is to filter the results searched
     *	
     * 
     * @author Benker
     * @param none
     * @return void
     * 
     */
    @FXML
    private void refineSearch() {
    	// this line suppose not to be here as currSearch is available in task6
    	List<Item> currSearch = new ArrayList<Item>();
    	
    	// the word to filter
    	final String filter = textFieldKeyword.getText();
    	// handle to conditions
    	Predicate<Item> pred = p-> p.getTitle().indexOf(filter) == -1;
    	// remove if condition meet
    	currSearch.removeIf(pred);
    	// update the UI with new items list
//    	updateUI();
//    	refineButton.setDisable(true);
    	
    }
    
    /**
     * 	This function is helper function to test refineSearch
     * 
     * 	@author Benker
     * 	@param	items the list of items to be tested
     * 	@param	k the keyword that to be filter
     * 	@return	the size of currSearch after filter
     */
    public int testRefineSearch(List<Item> items, String k) {
    	
//    	currSearch = items;
//    	textFieldKeyword.setText(k);
//    	refineSearch();
//    	return currSearch.size();
    	
    	return 0;
    }
    
}
