package hust.soict.hedspi.aims;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import hust.soict.hedspi.aims.authentication.Authentication;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
// 20225651
public class Aims {
    private static Scanner sc = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();
    public static void main(String[] args) {
        store.SetAuthentication(Authentication.StoreManager);
        sc = new Scanner(System.in);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 
            19.95f, 87, "Roger Allers");
        CompactDisc cd1 = new CompactDisc("Star wars", "Science Fiction", 
            24.95f, 87, "Geogre Lucas", "John Williams");
        cd1.addTrack(new Track("Duel of the Fates", 240));
        cd1.addTrack(new Track("Anakin vs Obi-Wan", 180));
        Book book1 = new Book("One Piece", "Manga", 18.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Dazzling light in the summer", "Inazuma", 
        19.99f, 123, "miHoYo");
        CompactDisc cd2 = new CompactDisc("Liyue", "Gensin Impact", 
            24.99f, 0, "miHoyo", "Yu-Peng Chen");
        cd2.addTrack(new Track("Rapid as Wildfires", 240));
        cd2.addTrack(new Track("Moon in One's Cup", 180));
        Book book2 = new Book("The Art of War", "Sun Tzu", 19.99f);
        store.addMedia(dvd1);
        store.addMedia(cd1); 
        store.addMedia(book1);
        store.addMedia(dvd2);
        store.addMedia(cd2);
        store.addMedia(book2);
        cart.addMedia(dvd1);
        cart.addMedia(cd1);
        cart.addMedia(book1);
        showMenu();
        sc.close();
    }
    public static void showMenu(){
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println(Menu.ViewStore.getValue() + ". View store");
            System.out.println(Menu.UpdateStore.getValue() + ". Update store");
            System.out.println(Menu.SeeCurrentCart.getValue() + ". See current cart");
            System.out.println(Menu.Exit.getValue() + ". Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: ");
            int option = sc.nextInt();
            if (option == Menu.ViewStore.getValue()) {
                storeMenu();
            } else if (option == Menu.UpdateStore.getValue()) {
                updateStore();
            } else if (option == Menu.SeeCurrentCart.getValue()) {
                cartMenu();
            } else if (option == Menu.Exit.getValue()) {
                System.out.println("Goodbye!");
                break;
            } else{
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    public static void storeMenu(){
        while (true) {
            store.print();
            System.out.println("Store Menu: ");
            System.out.println("--------------------------------");
            System.out.println(StoreMenu.SeeMediaDetails.getValue() + ". See media details");
            System.out.println(StoreMenu.AddMediaToCart.getValue() + ". Add media to cart");
            System.out.println(StoreMenu.PlayMedia.getValue() + ". Play media");
            System.out.println(StoreMenu.SeeCurrentCart.getValue() + ". See current cart");
            System.out.println(StoreMenu.Back.getValue() + ". Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == StoreMenu.SeeMediaDetails.getValue()) {
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    mediaDetailsMenu(media);
                }
                else{
                    System.out.println("Media not found");
                }
            } else if (option == StoreMenu.AddMediaToCart.getValue()) {
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    cart.addMedia(media);
                    System.out.println("Number of media in cart: " + cart.getItemsOrdered().size());
                }
                else{
                    System.out.println("Media not found");
                }    
            } else if (option == StoreMenu.PlayMedia.getValue()) {
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    if (media instanceof Disc) ((Disc) media).play();
                    else System.out.println("This media is not a disc");
                }
                else{
                    System.out.println("Media not found");
                }
            } else if (option == StoreMenu.SeeCurrentCart.getValue()) {
                System.out.println("Items in cart: ");
                cartMenu();
            } else if (option == StoreMenu.Back.getValue()) {
                showMenu();
                break;
            } else{
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    public static void mediaDetailsMenu(Media media){
        while (true) {
            List<Integer> selectableOptions = new ArrayList<>();
            System.out.println(media.getTitle() + " detail Menu: ");
            System.out.println("--------------------------------");
            System.out.println(MediaDetailsMenu.AddToCart.getValue() + ". Add to cart");
            selectableOptions.add(MediaDetailsMenu.AddToCart.getValue());
            if (media instanceof Disc){
                System.out.println(MediaDetailsMenu.Play.getValue() + ". Play");
                selectableOptions.add(MediaDetailsMenu.Play.getValue());
            }
            System.out.println(MediaDetailsMenu.Back.getValue() + ". Back");
            selectableOptions.add(MediaDetailsMenu.Back.getValue());
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: ");
            int option = sc.nextInt();
            if (selectableOptions.contains(option)){
                if (option == MediaDetailsMenu.AddToCart.getValue()) {
                    cart.addMedia(media);
                } else if (option == MediaDetailsMenu.Play.getValue()) {
                    ((Disc) media).play();
                } else if (option == MediaDetailsMenu.Back.getValue()) {
                    break;
                }
            } else{
                System.out.println("Invalid option. Please choose again.");
            }
        } 
    }
    public static void updateStore(){
        while (true) {
            System.out.println("Update Store: ");
            System.out.println("--------------------------------");
            System.out.println(UpdateStoreMenu.AddMedia.getValue() + ". Add media");
            System.out.println(UpdateStoreMenu.RemoveMedia.getValue() + ". Remove media");
            System.out.println(UpdateStoreMenu.Back.getValue() + ". Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == UpdateStoreMenu.AddMedia.getValue()) {
                System.out.println("Enter the type of media (CD/DVD/Book): ");
                String type = sc.nextLine();
                if (type.equals("CD")){
                    System.out.println("Enter the title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the category: ");
                    String category = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    float cost = sc.nextFloat();
                    System.out.println("Enter the length: ");
                    int length = sc.nextInt();
                    System.out.println("Enter the director: ");
                    String director = sc.nextLine();
                    System.out.println("Enter the artist: ");
                    String artist = sc.nextLine();
                    CompactDisc dvd = new CompactDisc(title, category, cost, length, director, artist);
                    store.addMedia(dvd);
                } else if (type.equals("DVD")){
                    System.out.println("Enter the title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the category: ");
                    String category = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    float cost = sc.nextFloat();
                    System.out.println("Enter the length: ");
                    int length = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the director: ");
                    String director = sc.nextLine();
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
                    store.addMedia(dvd);
                } else if (type.equals("Book")){
                    System.out.println("Enter the title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the category: ");
                    String category = sc.nextLine();
                    System.out.println("Enter the cost: ");
                    float cost = sc.nextFloat();
                    Book book = new Book(title, category, cost);
                    store.addMedia(book);
                } else{
                    System.out.println("Invalid type");
                }
            } else if (option == UpdateStoreMenu.RemoveMedia.getValue()) {
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    store.removeMedia(media);
                }
                else{
                    System.out.println("Media not found");
                }
            } else if (option == UpdateStoreMenu.Back.getValue()) {
                break;
            }
            else{
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    public static void cartMenu(){
        cart.print();
        while (true){
            System.out.println("Cart Menu: ");
		    System.out.println("--------------------------------");
            System.out.println(CartMenu.Filter.getValue() + ". Filter medias in the cart"); 
            System.out.println(CartMenu.Sort.getValue() + ". Sort medias in the cart");
            System.out.println(CartMenu.Remove.getValue() + ". Remove media from the cart");
            System.out.println(CartMenu.Play.getValue() + ". Play a media in the cart");
            System.out.println(CartMenu.PlaceOrder.getValue() + ". Place order");
            System.out.println(CartMenu.Back.getValue() + ". Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == CartMenu.Filter.getValue()){
                System.out.println("Filter by: ");
                System.out.println(Filter.ById.getValue() + ". ID");
                System.out.println(Filter.ByTitle.getValue() + ". Title");
                System.out.println(Filter.Back.getValue() + ". Back");
                System.out.println("Please choose a number: ");
                int filterOption = sc.nextInt();
                sc.nextLine();
                if (filterOption == Filter.ById.getValue()){
                    System.out.println("Enter the ID: ");
                    int id = sc.nextInt();
                    cart.searchById(id);
                } else if (filterOption == Filter.ByTitle.getValue()){
                    System.out.println("Enter the title: ");
                    String title = sc.nextLine();
                    cart.searchByTitle(title);
                } else if (filterOption == Filter.Back.getValue()){
                    continue;
                } else{
                    System.out.println("Invalid option. Please choose again.");
                }
            } else if (option == CartMenu.Sort.getValue()){
                System.out.println("Sort by: ");
                System.out.println(Sort.ByCost.getValue() + ". Cost");
                System.out.println(Sort.ByTitle.getValue() + ". Title");
                System.out.println(Sort.Back.getValue() + ". Back");
                System.out.println("Please choose a number: ");
                int sortOption = sc.nextInt();
                if (sortOption == Sort.ByCost.getValue()){
                    cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
                    cart.print();
                } else if (sortOption == Sort.ByTitle.getValue()){
                    cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
                    cart.print();
                } else if (sortOption == Sort.Back.getValue()){
                    continue;
                } else{
                    System.out.println("Invalid option. Please choose again.");
                }
            } else if (option == CartMenu.Remove.getValue()){
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    cart.removeMedia(media);
                }
                else{
                    System.out.println("Media not found");
                }
            } else if (option == CartMenu.Play.getValue()){
                System.out.println("Enter the title: ");
                String title = sc.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null){
                    if (media instanceof Disc) ((Disc) media).play();
                    else System.out.println("This media is not a disc");
                }
                else{
                    System.out.println("Media not found");
                }
            } else if (option == CartMenu.PlaceOrder.getValue()){
                System.out.println("Order placed");
                cart.emptyCart();
                break;
            } else if (option == CartMenu.Back.getValue()){
                break;
            } else{
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    public enum Menu{
        Exit(0), ViewStore(1), UpdateStore(2), SeeCurrentCart(3);
        private int value;
        private Menu(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum StoreMenu{
        SeeMediaDetails(1), AddMediaToCart(2), PlayMedia(3), SeeCurrentCart(4), Back(0);
        private int value;
        private StoreMenu(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum MediaDetailsMenu{
        AddToCart(1), Play(2), Back(0);
        private int value;
        private MediaDetailsMenu(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum UpdateStoreMenu{
        AddMedia(1), RemoveMedia(2), Back(0);
        private int value;
        private UpdateStoreMenu(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum CartMenu{
        Filter(1), Sort(2), Remove(3), Play(4), PlaceOrder(5), Back(0);
        private int value;
        private CartMenu(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum Filter{
        ById(1), ByTitle(2), Back(0);
        private int value;
        private Filter(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    public enum Sort{
        ByCost(1), ByTitle(2), Back(0);
        private int value;
        private Sort(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
}
