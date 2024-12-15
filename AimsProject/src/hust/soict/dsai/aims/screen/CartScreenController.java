package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	private Store store;
	
	@FXML private TableView<Media> tblMedia;
	@FXML private TableColumn<Media, String> colMediaTitle;
	@FXML private TableColumn<Media, String> colMediaCategory;
	@FXML private TableColumn<Media, Float> colMediaCost;
	@FXML private Button btnPlay;
	@FXML private Button btnRemove;
	@FXML private Button btnPlaceOrder;
	@FXML private Label lbTotalCost;
	
	@FXML private MenuItem menuAddCD;
    @FXML private MenuItem menuAddBook;
    @FXML private MenuItem menuAddDVD;
    @FXML private MenuItem menuViewStore;
	
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, 
							Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}});
		
		lbTotalCost.setText(cart.totalCost() + " $");
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		lbTotalCost.setText(cart.totalCost() + " $");
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.clear();
		lbTotalCost.setText(cart.totalCost() + " $");
		System.out.println("An order is created.");
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof Playable) {
			Playable playable = (Playable) media;
			try {
				playable.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
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
    
    @FXML
    void menuAddCDPressed(ActionEvent event) {
    	AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(cart, store);
    }
}