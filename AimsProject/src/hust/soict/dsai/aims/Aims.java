package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	private static Store store = new Store();
	
	public static void main(String[] args) {
		initializeStore();
		Cart anOrder = new Cart();
		StoreScreen screen = new StoreScreen(store, anOrder);
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner, anOrder);
		scanner.close();
	}
	
	public static void initializeStore() {
		Book book1 = new Book("Harry Potter Vol. 1", "Magical", 19.99f);
		book1.addAuthor("J. K. Rowling");
		
		CompactDisc cd1 = new CompactDisc("The Marshall Mathers LP", "Rap", 30.00f, "Dr. Dre", "Eminem");
		Track track1 = new Track("Stan", 5);
		Track track2 = new Track("Criminal", 4);
		cd1.addTrack(track1, track2);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", "Sci-fi", 35, "George Lucas", 150);
		
		store.addMedia(book1, cd1, dvd1);
		
	}
	
	public static void showMenu(Scanner scanner, Cart cart) {
		int input;
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("----------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1: 
				storeMenu(scanner, cart);
				break;
			case 2:
				updateStore(scanner);
				break;
			case 3:
				cartMenu(scanner, cart);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
	public static void storeMenu(Scanner scanner, Cart cart) {
		int input;
		while(true) {
			store.viewStore();
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. See a media's details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				storeMediaDetails(scanner);
				break;
			case 2:
				cartAddMedia(scanner, cart);
				break;
			case 3:
				storePlayMedia(scanner);
				break;
			case 4:
				cartMenu(scanner, cart);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
	public static void mediaDetailsMenu(Scanner scanner, Cart cart, Media media) {
		int input;
		media.showDetails();
		System.out.println("Options: ");
		System.out.println("----------------------------------");
		System.out.println("1. Add to cart");
		if(media instanceof Playable) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("----------------------------------");
		if(media instanceof Disc) System.out.println("Please choose a number: 0-1");
		else System.out.println("Please choose a number: 0-1-2");
		
		while(true) {
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				try {
					cart.addMedia(media);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(media.getTitle() + " is added to cart.");
				break;
			case 2:
				if(media instanceof Playable) {
					Playable p = (Playable) media;
					try {
						p.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
	public static void cartMenu(Scanner scanner, Cart cart) {
		int input;
		while(true) {
			cart.viewCart();
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				filterCart(scanner, cart);
				break;
			case 2:
				sortingOptions(scanner, cart);
				break;
			case 3:
				cartRemoveMedia(scanner, cart);
				break;
			case 4:
				cartPlayMedia(scanner, cart);
				break;
			case 5:
				System.out.println("An order is created.");
				cart.clear();
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
	public static void sortingOptions(Scanner scanner, Cart cart) {
		int input;
		System.out.println("Please choose ordering rule:");
		System.out.println("(Note: The remaining rule will be used as secondary rule)");
		System.out.println("1. Sort ascending by title");
		System.out.println("2. Sort descending by cost");
		System.out.println("0. Back");
		while (true) {
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				cart.sortByTitleCost();
				System.out.println("Cart sorted by title.");
				break;
			case 2:
				cart.sortByCostTitle();
				System.out.println("Cart sorted by cost.");
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
				continue;
			}
		}
	}
	
	public static void updateStore(Scanner scanner) {
		int input;
		while (true) {
			store.viewStore();
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Add media to store");
			System.out.println("2. Remove media from store");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				storeAddMedia(scanner);
				break;
			case 2:
				storeRemoveMedia(scanner);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
	public static void storeAddMedia(Scanner scanner) {
		Media newMedia;
		String input;
		String[] info;
		
		System.out.println("Enter details of media in one of the following format:");
		System.out.println("\tBook,Title,Category,Cost");
		System.out.println("\tCD,Title,Category,Cost,Director,Artist");
		System.out.println("\tDVD,Title,Category,Cost,Director,Length");
	
		while (true) {
			System.out.println("Type \"exit\" to return to previous menu.");
			input = scanner.nextLine();
			
			if (input.equals("exit")) return;
			
			info = input.split(",");
			switch(info[0]) {
			case "Book":
				newMedia = new Book(info[1], info[2], Float.parseFloat(info[3]));
				break;
			case "DVD":
				newMedia = new DigitalVideoDisc(info[1], info[2], Float.parseFloat(info[3]), info[4], Integer.parseInt(info[5]));
				break;
			case "CD":
				newMedia = new CompactDisc(info[1], info[2], Float.parseFloat(info[3]), info[4], info[5]);
				break;
			default:
				System.out.println("Invalid format! Please type again.");
				continue;
			}
			break;
		}
		
		store.addMedia(newMedia);
	}

	public static void storeRemoveMedia(Scanner scanner) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (store.isAvailable(title, id)) {
			Media media = store.findMedia(title, id);
			store.removeMedia(media);
		}
		else System.out.println("Item not found in store");
	}
	
	public static void storeMediaDetails(Scanner scanner) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (store.isAvailable(title, id)) {
			Media media = store.findMedia(title, id);
			media.showDetails();
		}
		else System.out.println("Item not found in cart");
	}
	
	public static void storePlayMedia(Scanner scanner) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (store.isAvailable(title, id)) {
			Media media = store.findMedia(title, id);
			if (media instanceof Playable) {
				Playable p = (Playable) media;
				try {
					p.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else System.out.println("The selected media is unplayable.");
		}
		else System.out.println("Item not found in store");
	}
	
	public static void cartAddMedia(Scanner scanner, Cart cart) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (store.isAvailable(title, id)) {
			Media result = store.findMedia(title, id);
			try {
				cart.addMedia(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else System.out.println("Item not found in store");
	}
	
	public static void cartRemoveMedia(Scanner scanner, Cart cart) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (cart.isAvailable(title, id)) {
			Media result = cart.findMedia(title, id);
			cart.removeMedia(result);
		}
		else System.out.println("Item not found in cart");
	}
	
	public static void cartPlayMedia(Scanner scanner, Cart cart) {
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		if (cart.isAvailable(title, id)) {
			Media result = cart.findMedia(title, id);
			if (result instanceof Playable) {
				Playable p = (Playable) result;
				try {
					p.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else System.out.println("The selected media is unplayable.");
		}
		else System.out.println("Item not found in cart");
	}
	
	public static void filterCart(Scanner scanner, Cart cart) {
		int input;
		while(true) {
			cart.viewCart();
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Filter by ID");
			System.out.println("2. Filter by title");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 0: return;
			case 1:
				System.out.println("Enter ID:");
				input = scanner.nextInt();
				cart.filterMedia(input);
				break;
			case 2:
				System.out.println("Enter keyword(s), separated by spaces:");
				String[] keywords = scanner.nextLine().split(" ");
				cart.filterMedia(keywords);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
		}
	}
	
}