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
// by Calvin, for task 4
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
// end by Calvin for task 4

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Hyperlink;
import java.util.List;
import java.util.Vector;

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
 * added by Calvin: Controller now extends WebScrapperApplication to enable web browsing
 */
public class Controller extends WebScraperApplication{

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
    
    // by Calvin, task 4
    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> labelTableTitle;

    @FXML
    private TableColumn<Item, Double> labelTablePrice;

    @FXML
    private TableColumn<Item, String> labelTableURL;

    @FXML
    private TableColumn<Item, String> labelTableDate;
    
    private final HostServices host;
    // end by Calvin, task 4
    
    private WebScraper scraper;
    
    // by Calvin, task 6
    @FXML
    private MenuItem labelMenuLastSearch;

    @FXML
    private MenuItem labelAboutTeam;
    
    private List<Item> currSearch;

    private List<Item> lastSearch;
    // end by Calvin, task 6
    
    private boolean test_mode; //added by Calvin, 4.1
    
    /**
     * Default controller
     * @author imc4kmacpro
     */
    public Controller() {
    	test_mode = false; // added by Calvin, 4.1
    	scraper = new WebScraper();
      // by Calvin, task 6
    	labelMenuLastSearch = new MenuItem();
      // end by Calvin, task 6
    	
    	// by Calvin, task 4
    	host = this.getHostServices();
    	// end by Calvin, task 4
    }
    
    /***************************************************/
    /*
     * Test method: initialize GUI objects
     */
    public void initGUIObjs() {
    	labelCount = new Label();
    	labelPrice = new Label();
    	labelMin = new Hyperlink();
    	labelLatest = new Hyperlink();
    	textFieldKeyword = new TextField();
    	textAreaConsole = new TextArea();
    	table = new TableView();
    	labelTableTitle = new TableColumn<>();
    	labelTablePrice = new TableColumn<>();
    	labelTableURL = new TableColumn<>();
    	labelTableDate = new TableColumn<>();
    	labelMenuLastSearch = new MenuItem();
    	labelAboutTeam = new MenuItem();
    }
    /***************************************************/

    /**
     * Default initializer. It is empty.
     * @author imc4kmacpro Benker
     */
    @FXML
    private void initialize() {
    	// added by Benker for task5
//    	 refineButton.setDisable(true);
    	// ended task5
    	labelMenuLastSearch.setDisable(true);
    }
    
    /**
     * Called when the search button is pressed.
     * NOTE: part of code should be refactored into a method: updateUI()
     * @author imc4kmacpro Benker
     */
    @FXML
    private void actionSearch() {
    	System.out.println("actionSearch: " + textFieldKeyword.getText());
    	List<Item> result = scraper.scrape(textFieldKeyword.getText());
    	updateUI(result);
    }
    
    
    /**
     * 4.1
     * refactored method to update UI all at once
     * @author imc4kmacpro
     * @param list the list of items to be shown in console, summary and table
     */
    private void updateUI(List<Item> list) {
    	String output = "";
    	for (Item item : list) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
    	}
    	textAreaConsole.setText(output);
    	
    	
    	// added by Benker for task5
    	// set refine button disable to false after search
//    	if(result.size()>0) {
//    		refineButton.setDisable(false);
//    	}
    	// end task5
      
      // by Calvin, task 6
    	updateSearchLists(list);
      // end by Calvin, task 6
    	
      // by Calvin, task 4
    	createTable(list);
    	// end by Calvin, task 4
    }
    
    /**
     * test method for actionSearch
     * @author imc4kmacpro
     * @param keyword
     */
    public List<Item> actionSearchTest(String keyword) {

    	textFieldKeyword.setText(keyword);
    	actionSearch();
    	return currSearch;
    }
    
    /**
     * test method for getting scraper object
     * @author imc4kmacpro
     * @return scraper
     */
    public WebScraper getScraper() {
    	return scraper;
    }
    
    
    // by Calvin, open link helper function
    /**
     * opens the url specified in url in a new browser window
     * call method:
     * item.getUrl().addEventHandler(ActionEvent.ACTION, (e) -> openDoc(item.getUrlText()));
     * or 
     * openDoc(label.getText());
     * @author imc4kmacpro
     * @param url
     */
    private void openDoc(String url) {
    	host.showDocument(url);
    }
    
    /**
     * test method for openDoc
     * @author imc4kmacpro
     * @param url the string that requires the browser to open
     */
    public void openDocTest(String url) {
    	openDoc(url);
    }
    // end by Calvin, hyperlink helper function
    
    // by Calvin, task 4
    /**
     * this function is for creating a list to be added into the table for task 4
     * @author imc4kmacpro
     * @param items
     * @return a list that can be put into a table view
     */
    private ObservableList<Item> getList(List<Item> items){
    	ObservableList<Item> olist = FXCollections.observableArrayList();
    	for(Item item: items) {
    		olist.add(item);
    	}
    	return olist;
    }
    
    /**
     * public test method for getList()
     * @author imc4kmacpro
     * @param List<Item> items
     * @return ObservableList<Item>
     */
    public ObservableList<Item> getListTest(List<Item> items){
    	return getList(items);
    }
    
    /**
     * this function puts everything in items into the table view
     * requires function getList(), openDoc()
     * @author imc4kmacpro
     * @param List<Item> items
     * @return void
     * @exception none
     */
    public void createTable(List<Item> items) {
    	ObservableList<Item> tableList = getList(items);
    	labelTableTitle.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
    	labelTablePrice.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
    	labelTableURL.setCellValueFactory(new PropertyValueFactory<Item, String>("url"));
    	labelTableURL.setCellFactory(tc -> {
    		TableCell<Item, String> cell = new TableCell<Item, String>(){
    			@Override
    			protected void updateItem(String item, boolean empty) {
    				super.updateItem(item,  empty);
    				setText(item);
    			}
    		};
    		cell.setOnMouseClicked(e -> {
    			openDoc(cell.getText());
    			System.out.println(cell.getText());
    		});
    		return cell;
    	});
    	labelTableDate.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
    	table.setItems(tableList);
    }
    // end by Calvin, task 4
    
    // by Calvin, task 6
    /**
     * task 6, update the searched lists upon new searches
     * @author imc4kmacpro
     * @param List<Item> items
     * @return void
     * @exception none
     */
    private void updateSearchLists(List<Item> items) {
    	if(currSearch != null) { // not first search, enable lastSearch function
    		labelMenuLastSearch.setDisable(false);
    	}
    	lastSearch = currSearch;
    	currSearch = items;
    }
    
    /**
     * for testing
     * @author imc4kmacpro
     * @param List<Item> items
     */
    public void updateSearchListsTest(List<Item> items) {
    	updateSearchLists(items);
    }
    
    /**
     * for testing
     * @author imc4kmacpro
     * @param null
     * @return List<Item> currSearch
     * @exception none
     */
    public List<Item> getCurrSearch() {
    	return currSearch;
    }
    
    /**
     * for testing
     * @author imc4kmacpro
     * @param null
     * @return lastSearch
     * @exception none
     */
    public List<Item> getLastSearch() {
    	return lastSearch;
    }
    
    /**
     * task 6, show about team
     * @author imc4kmacpro
     * @param ActionEvent event
     * @return void
     * @exception none
     */
    @FXML
    public void showAboutTeam(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("About our team");
    	alert.setHeaderText("Information about our team");
    	alert.setContentText("Team member 1: Chu Cheuk Kiu\tckchuad\tImC4k\n"
    			+ "Team member 2: Leung Lai Yung\tlyleungad\tBenker-Leung\n"
    			+ "Team member 3: Tang Au Wa\tawtang\tdavidtang1006\n");
    	alert.setResizable(true);
    	alert.showAndWait();
    }
    
    /**
     * task 6, quit button
     * @author imc4kmacpro
     * @param ActionEvent event
     * @return void
     * @exception none
     */
    @FXML
    public void terminateWindow(ActionEvent event) {
    	Platform.exit();
    }
    
    /**
     * task 6, close button
     * @author imc4kmacpro
     * @param null
     * @return void
     * @exception none
     */
    @FXML
    void closeWindow() {
    	lastSearch = currSearch;
    	if(lastSearch != null) {
    		labelMenuLastSearch.setDisable(false); // enable last search
    	}
    	
    	// Console tab
    	textAreaConsole.setText(""); // resets console

    	// Summary tab
    	labelPrice.setText("<AvgPrice>");
    	labelMin.setText("<Lowest>");
    	labelMin.setVisited(false);
    	labelLatest.setText("<Latest>");
    	labelLatest.setVisited(false);

    	// Table tab
    	Vector<Item> items = new Vector<Item>();
		List<Item> items_list = items;
		ObservableList<Item> emptyList = getList(items_list);
    	table.setItems(emptyList);

    }
    
    /**
     * task 6, reload previous search state
     * @author imc4kmacpro
     * @param null
     * @return void
     * @exception none
     */
    @FXML
    void reloadLastSearch() {
    	System.out.println("reloading last search");
    	labelMenuLastSearch.setDisable(true);
    	String output = "";
    	for (Item item : lastSearch) {
    		output += item.getTitle() + "\t" + item.getPrice() + "\t" + item.getUrl() + "\n";
    	}
    	textAreaConsole.setText(output);
    	updateSearchLists(lastSearch);
//    	getItemsAndDisplay(false);
    	createTable(lastSearch);
    } 
  // end by Calvin, task 6
    
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
    	// the word to filter
    	final String filter = textFieldKeyword.getText();
    	// handle to conditions
    	Predicate<Item> pred = p-> p.getTitle().indexOf(filter) == -1;
    	// remove if condition meet
    	currSearch.removeIf(pred);
    	// update the UI with new items list
      // need one function to update UI
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
