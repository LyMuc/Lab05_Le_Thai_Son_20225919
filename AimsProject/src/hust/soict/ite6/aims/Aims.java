package hust.soict.ite6.aims;

import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.store.Store;

public class Aims {
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
}
	
	public static int InputFromUser()
	{
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		//scanner.close();
		return(input);
	}
	
	public static String TitleFromUser()
	{
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		//scanner.close();
		return(input);
	}


	public static void main(String[] args) {
		
		Store store = new Store();
		Cart cart= new Cart();
		showMenu();
		int input=InputFromUser();
		if(input==1)
		{
			store.displayItems();
			storeMenu();
			input=InputFromUser();
			if(input ==1)
			{
				String titleString = TitleFromUser();
				store.displayItems(titleString);
				mediaDetailsMenu();
			}
			else if (input==2)
			{
				String titleString = TitleFromUser();
				cart.addMedia(store.isMatch(titleString));
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

