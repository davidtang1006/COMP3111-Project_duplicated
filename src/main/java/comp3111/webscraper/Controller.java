/**
 * 
 */
package comp3111.webscraper;

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
    private TableColumn<Item, Hyperlink> labelTableURL;

    @FXML
    private TableColumn<Item, String> labelTableDate;
    
    private final HostServices host;
    // end by Calvin, task 4
    
    private WebScraper scraper;
    
    /**
     * Default controller
     */
    public Controller() {
    	scraper = new WebScraper();
    	// by Calvin, task 4
    	host = this.getHostServices();
    	// end by Calvin, task 4
    }

    /**
     * Default initializer. It is empty.
     */
    @FXML
    private void initialize() {
    	textAreaConsole.setText("Branch task 4");
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
    	// by Calvin, task 4
    	createTable(result);
    	// end by Calvin, task 4
    }
    
    /**
     * Called when the new button is pressed. Very dummy action - print something in the command prompt.
     */
    @FXML
    private void actionNew() {
    	System.out.println("actionNew");
    }
    
    // by Calvin, hyperlink helper function
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
    // end by Calvin, hyperlink helper function
    
    // by Calvin, task 4
    /**
     * this function is for creating a list to be added into the table for task 4
     * @author imc4kmacpro
     * @param List<Item> items
     * @return ObservableList<Item>
     */
    public ObservableList<Item> getList(List<Item> items){
    	ObservableList<Item> list = FXCollections.observableArrayList();
    	for(Item item: items) {
    		list.add(item);
    	}
    	return list;
    }
    
    /**
     * this function puts everything in items into the table view
     * requires function getList(), openDoc()
     * @author imc4kmacpro
     * @param items
     */
    public void createTable(List<Item> items) {
    	for(Item item: items) {
    		item.getUrl().addEventHandler(ActionEvent.ACTION, (e) -> openDoc(item.getUrlText()));
    	}
    	ObservableList<Item> tableList = getList(items);
    	labelTableTitle.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
    	labelTablePrice.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
    	labelTableURL.setCellValueFactory(new PropertyValueFactory<Item, Hyperlink>("url"));
    	labelTableDate.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
    	table.setItems(tableList);
    }
    // end by Calvin, task 4
}
