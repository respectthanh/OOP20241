package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {

	private Cart cart;
	private Store store;
	
	public AddItemToStoreScreen(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	protected Store getStore() {
		return store;
	}
	
	protected Cart getCart() {
		return cart;
	}
}