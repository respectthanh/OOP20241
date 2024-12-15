package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddDVDScreenController {
	
	private Store store;
	private Cart cart;
    @FXML private TextField tfTitle;
    @FXML private TextField tfCategory;
    @FXML private TextField tfCost;
    @FXML private TextField tfDirector;
    @FXML private TextField tfLength;
    
    @FXML private Button btnAdd;
    @FXML private MenuItem menuViewCart;
    @FXML private MenuItem menuAddCD;
    @FXML private MenuItem menuAddBook;
    @FXML private MenuItem menuViewStore;
    
    public AddDVDScreenController(Cart cart, Store store) {
    	this.store = store;
    	this.cart = cart;
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
    	DigitalVideoDisc newDVD = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), 
    			Float.parseFloat(tfCost.getText()), tfDirector.getText(), Integer.parseInt(tfLength.getText()));
    	store.addMedia(newDVD);
    }
    
    @FXML
    void menuViewCartPressed(ActionEvent event) {
    	CartScreen cartScreen = new CartScreen(cart, store);
    }
    
    @FXML
    void menuAddCDPressed(ActionEvent event) {
    	AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(cart, store);
    }
    
    @FXML
    void menuAddBookPressed(ActionEvent event) {
    	AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(cart, store);
    }
    
    @FXML
    void menuViewStorePressed(ActionEvent event) {
    	StoreScreen storeScreen = new StoreScreen(store, cart);
    }
    
}