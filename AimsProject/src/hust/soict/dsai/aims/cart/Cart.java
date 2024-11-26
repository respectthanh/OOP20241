package hust.soict.dsai.aims.cart;
// import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 100;
    private ArrayList<Media> items = new ArrayList<Media>();

    public void addMedia(Media media){
        if (items.size() == 20){
            System.out.println("The cart is already full");
            return;
        }
        items.add(media);
        System.out.println("The media was added to the cart");
    }
    public void removeMedia(Media media){
        if (items.contains(media)){
            items.remove(media);
            System.out.println("The media was removed from the cart");
        }
        else{
            System.out.println("The media doesn't exist in the cart");
        }
    }

    public void placeOrder(){
        System.out.println("The order has been created");
        items.clear();
    }

    public float totalCost(){
        float cost = 0;
        int qtyOrdered = items.size();
        for (int i = 0; i < qtyOrdered; i++){
            cost += items.get(i).getCost();
        }
        return cost;
    }
    public Media searchCartByTitle(String title){
        int qtyOrdered = items.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (items.get(i).isMatch(title)){
                // System.out.println(items.get(i).toString());
                return items.get(i);
            }
        }
        return null;
    }
    public Media searchCartByID(int id){
        int qtyOrdered = items.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (items.get(i).isMatch(id)){
                // System.out.println(items.get(i).toString());
                return items.get(i);
            }
        }
        return null;
    }
    public void filterMedias(int id){
        Media item = searchCartByID(id);
        System.out.println(item);
    }
    public void filterMedias(String title){
        Media item = searchCartByTitle(title);
        System.out.println(item);
    }
    public void sortMedias(int option){
        if (option == 1) {
            items.sort(Media.COMPARE_BY_COST_TITLE);
        }
        else{
            items.sort(Media.COMPARE_BY_TITLE_COST);
        }
        display();
    }
    public void display(){
        for (int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).toString());
        }
    }
}