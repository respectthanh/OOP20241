package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    private DigitalVideoDisc[] items = new DigitalVideoDisc[100];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 100) {
            items[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        if (qtyOrdered + dvdList.length < 100){
            for (DigitalVideoDisc dvd: dvdList){
                addDigitalVideoDisc(dvd);
            }
            System.out.println("All the discs in the list have been added");
        }
        else{
            System.out.println("Maximum number of orders exceeded");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered <= 98) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }
        else{
            System.out.println("Maximum number of orders exceeded");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--qtyOrdered] = null;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return total;
    }
    
    public void print(){
        for (int i = 0; i < qtyOrdered; i++){
            System.out.println(items[i].toString());
        }
    }
    public void searchCartByTitle(String title){
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (items[i].isMatch(title)){
                System.out.println(items[i].toString());
                check = true;
            }
        }
        if (!check){
            System.out.println("There is no DVD like that");
        }
    }
    public void searchCartByID(int id){
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (items[i].isMatch(id)){
                System.out.println(items[i].toString());
                check = true;
            }
        }
        if (!check){
            System.out.println("There is no DVD like that");
        }
    }
}