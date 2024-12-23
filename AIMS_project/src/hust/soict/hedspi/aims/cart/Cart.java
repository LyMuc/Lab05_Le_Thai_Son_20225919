package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.authentication.Authentication;
import hust.soict.hedspi.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// 20225651
public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private Authentication authentication;

    public Cart(){
        authentication = Authentication.Customer;
    }

    // Method to add a Media to the cart
    public void addMedia(Media media){
        if (authentication != Authentication.Customer){
            System.out.println("You are not allowed to add items to the cart");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The Media " + '\"' + media.getTitle() 
            + '\"' + " has been added!");
    }
    // Method to remove a Media from the cart
    public void removeMedia(Media media){
        if (authentication != Authentication.Customer){
            System.out.println("You are not allowed to remove items from the cart");
            return;
        }
        if (itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println("The Media " + '\"' + media.getTitle() 
                + '\"' + " has been removed!");
        } else {
            System.out.println("The Media " + '\"' + media.getTitle() 
                + '\"' + " is not in the cart!");
        }
    }

    // Method to calculate the total price of Media in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (Media media : itemsOrdered){
            media.print();
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("**************************************************");
    }

    // Method to search by ID
    public void searchById(int id) {
        for(int j = 0;j < itemsOrdered.size(); j++) {
            if(itemsOrdered.get(j).getId() == id) {
                System.out.print("Result: ");
                itemsOrdered.get(j).print();
                System.out.println();
                return;
            }
        }
        System.out.println("No match found !");
    }

    // Method to search by title
    public void searchByTitle(String title) {
        for (int j = 0; j < itemsOrdered.size(); j++) {
            if (itemsOrdered.get(j).getTitle().equals(title)) {
                System.out.print("Result: ");
                itemsOrdered.get(j).print();
                System.out.println();
                return;
            }
        }
        System.out.println("No match found !");
    }
    public void search(){
        System.out.println("Search by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input!");
            return;
        } finally {
            sc.close();
        }
        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = 0;
                try {
                    id = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    return;
                }
                searchById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                searchByTitle(title);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        sc.close();
    }
    public void emptyCart(){
        itemsOrdered.clear();
        System.out.println("Cart is empty!");
    }
    public ObservableList<Media> getItemsOrdered(){
        return itemsOrdered;
    }
    public void SetAuth(Authentication auth){
        this.authentication = auth;
    }
}
