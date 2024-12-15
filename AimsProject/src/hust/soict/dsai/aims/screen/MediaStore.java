package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {

	private Media media;
	private Cart cart;
	private ActionListener btnListener = new ButtonListener();
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCart = new JButton("Add to cart");
		addToCart.addActionListener(btnListener);
		container.add(addToCart);
		
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			play.addActionListener(btnListener);
			container.add(play);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String button = event.getActionCommand();
			if (button.equals("Add to cart")) {
				try {
					cart.addMedia(media);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (button.equals("Play")) {
				Playable playable = (Playable) media;
				try {
					playable.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
}