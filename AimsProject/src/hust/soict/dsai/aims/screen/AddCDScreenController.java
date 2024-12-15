package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddCDScreenController {
	
	private Store store;
	private Cart cart;
    @FXML private TextField tfTitle;
    @FXML private TextField tfCategory;
    @FXML private TextField tfCost;
    @FXML private TextField tfDirector;
    @FXML private TextField tfArtist;
    @FXML private TextField tfTracks;
    
    @FXML private Button btnAdd;
    @FXML private MenuItem menuViewCart;
    @FXML private MenuItem menuAddBook;
    @FXML private MenuItem menuAddDVD;
    @FXML private MenuItem menuViewStore;
    
    public AddCDScreenController(Cart cart, Store store) {
    	this.store = store;
    	this.cart = cart;
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
    	CompactDisc newCD = new CompactDisc(tfTitle.getText(), tfCategory.getText(), 
    			Float.parseFloat(tfCost.getText()), tfDirector.getText(), tfArtist.getText());
    	
    	String[] tracks = tfTracks.getText().split(",");
    	if (tracks.length > 0) {
    		for (String track : tracks) {
    			String[] info = track.split(":");
    			newCD.addTrack(new Track(info[0], Integer.parseInt(info[1])));
    		}
    	}
    	
    	store.addMedia(newCD);
    }
    
    @FXML
    void menuViewCartPressed(ActionEvent event) {
    	CartScreen cartScreen = new CartScreen(cart, store);
    }
    
    @FXML
    void menuAddBookPressed(ActionEvent event) {
    	AddBookToStoreScreen addCDScreen = new AddBookToStoreScreen(cart, store);
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