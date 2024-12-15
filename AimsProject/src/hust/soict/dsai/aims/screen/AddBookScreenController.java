package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddBookScreenController {
	
	private Store store;
	private Cart cart;
    @FXML private TextField tfTitle;
    @FXML private TextField tfCategory;
    @FXML private TextField tfCost;
    @FXML private TextField tfAuthors;
    @FXML private Button btnAdd;
    @FXML private MenuItem menuViewCart;
    @FXML private MenuItem menuAddCD;
    @FXML private MenuItem menuAddDVD;
    @FXML private MenuItem menuViewStore;
    
    public AddBookScreenController(Cart cart, Store store) {
    	this.store = store;
    	this.cart = cart;
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
    	Book newBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
    	String[] authors = tfAuthors.getText().split(",");
    	if (authors.length > 0) {
    		for (String author : authors) {
    			newBook.addAuthor(author);
    		}
    	}
    	store.addMedia(newBook);
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
    void menuAddDVDPressed(ActionEvent event) {
    	AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(cart, store);
    }
    
    @FXML
    void menuViewStorePressed(ActionEvent event) {
    	StoreScreen storeScreen = new StoreScreen(store, cart);
    }

}
