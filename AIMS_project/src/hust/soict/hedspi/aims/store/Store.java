package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.authentication.Authentication;
import hust.soict.hedspi.aims.media.Media;
// 20225651
public class Store {
    private List<Media> itemsInStore = new ArrayList<>();
    private Authentication authentication;

    public Store(){
        authentication = Authentication.Customer;
    }

    public void addMedia(Media media){
        if (authentication != Authentication.StoreManager){
            System.out.println("You are not allowed to add items to the store");
            return;
        }
        itemsInStore.add(media);
        System.out.println("The Media " + '\"' + media.getTitle() 
            + '\"' + " has been added to the store!");
    }

    public void removeMedia(Media media){
        if (authentication != Authentication.StoreManager){
            System.out.println("You are not allowed to remove items from the store");
            return;
        }
        if (itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("The Media " + '\"' + media.getTitle() 
                + '\"' + " has been removed from the store!");
        } else {
            System.out.println("The Media " + '\"' + media.getTitle() 
                + '\"' + " is not in the store!");
        }
    }
    public Media searchById(int id){
        for (Media media : itemsInStore){
            if (media.getId() == id){
                System.out.print("Result: ");
                media.print();
                System.out.println();
                return media;
            }
        }
        System.out.println("Media not found");
        return null;
    }
    public Media searchByTitle(String title){
        for (Media media : itemsInStore){
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.print("Result: ");
                media.print();
                System.out.println();
                return media;
            }
        }
        System.out.println("Media not found");
        return null;
    }
    public void print(){
        System.out.println("***********************STORE***********************");
        for (Media media : itemsInStore){
            media.print();
        }
        System.out.println("**************************************************");
    }
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void SetAuthentication(Authentication authentication){
        this.authentication = authentication;
    }
}
