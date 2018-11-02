/**
 * 
 */
package comp3111.webscraper;

// by Calvin, task 6
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// end by Calvin, task 6
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import java.util.List;


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
    
    // by Calvin, task 6
    @FXML
    private MenuItem labelMenuLastSearch;

    @FXML
    private MenuItem labelAboutTeam;
    
    private List<Item> currSearch;

    private List<Item> lastSearch;
    // end by Calvin, task 6
    
    /**
     * Default controller
     */
    public Controller() {
    	scraper = new WebScraper();
    	labelMenuLastSearch = new MenuItem();
    }

    /**
     * Default initializer. It is empty.
     */
    @FXML
    private void initialize() {
    	labelMenuLastSearch.setDisable(true);
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
    	updateSearchLists(result);
    }
    
    /**
     * Called when the new button is pressed. Very dummy action - print something in the command prompt.
     */
    @FXML
    private void actionNew() {
    	System.out.println("actionNew");
    }
    
    /**
     * task 6, update the searched lists upon new searches
     * @author imc4kmacpro
     * @param items
     */
    void updateSearchLists(List<Item> items) {
    	if(currSearch != null) { // not first search, enable lastSearch function
    		labelMenuLastSearch.setDisable(false);
    	}
    	lastSearch = currSearch;
    	currSearch = items;
    }
    
    /**
     * task 6, show about team
     * @author imc4kmacpro
     */
    @FXML
    void showAboutTeam(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("About our team");
    	alert.setHeaderText("Information about our team");
    	alert.setContentText("Team member 1: Chu Cheuk Kiu\tckchuad\tImC4k\n"
    			+ "Team member 2: Leung Lai Yung\tlyleungad\tBenker-Leung\n"
    			+ "Team member 3: David\'sname\tawtang\tdavidtang1006\n");
    	alert.setResizable(true);
    	alert.showAndWait();
    }
    
    /**
     * task 6, quit button
     * @author imc4kmacpro
     */
    @FXML
    void terminateWindow(ActionEvent event) throws Exception {
    	Platform.exit();
    }
    
    /**
     * task 6, close button
     * @author imc4kmacpro
     */
    @FXML
    void closeWindow() {
    	lastSearch = currSearch;
    	currSearch = null;
    	labelMenuLastSearch.setDisable(false); // enable last search

    	// Console tab
    	textAreaConsole.setText("");

    	// Summary tab
    	labelPrice.setText("<AvgPrice>");
    	labelMin.setText("<Lowest>");
    	labelMin.setVisited(false);
    	labelLatest.setText("<Latest>");
    	labelLatest.setVisited(false);

    	// Table tab
//    	createTable(currSearch);
    	ObservableList<Item> emptyList = FXCollections.observableArrayList();
//    	table.setItems(emptyList);

    }
    
    /**
     * task 6, reload previous search state
     * @author imc4kmacpro
     */
    @FXML
    void reloadLastSearch() {
    	labelMenuLastSearch.setDisable(true);
    	String output = "";
    	for (Item item : lastSearch) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrlText() + "\n";
    	}
    	textAreaConsole.setText(output);
//    	insertSummary(lastSearch);
//    	createTable(lastSearch);
    }
}
