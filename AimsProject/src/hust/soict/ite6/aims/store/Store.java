package hust.soict.ite6.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 1000;
	//private String authenticate;
	private List<Media> itemsInStore = new ArrayList<Media>();
	private int nbStoreManager;
	private int idStoreManager;
	public void setAuth()
	{
		//this.authenticate="Store Manager";
		this.nbStoreManager++;
		this.idStoreManager=this.nbStoreManager;
	}
	
	public int getNbStoreManager() {
		return nbStoreManager;
	}

	public int getIdStoreManager() {
		return idStoreManager;
	}
	
	public int addMedia(Media... discs)
	{
		int totalAdded = 0; // Biến để đếm số lượng media đã thêm thành công
	    for (Media disc : discs) {
	        if (itemsInStore.size() == MAX_ITEMS_IN_STORE) {
	            System.out.println("The store is full");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp media
	        boolean isDuplicate = false;
	        for (int index = 0; index < itemsInStore.size(); index++) {
	            if (itemsInStore.get(index).getTitle().equals(disc.getTitle())) {
	                System.out.println("The media " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	        }
	        
	        if (!isDuplicate) {
	            itemsInStore.add(disc);
	            totalAdded += 1;
	        }
	    }
	    
	    return totalAdded > 0 ? totalAdded : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	public int removeMedia(Media... discs)
	{
		int totalRemoved = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (Media disc : discs) {
	        if (itemsInStore.size() == 0) {
	            System.out.println("The store is empty");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < itemsInStore.size(); index++) {
	            if (itemsInStore.get(index).getTitle().equals(disc.getTitle())) {
	                //System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	            else System.out.println("The media " + disc.getTitle() + " is not in the list");
	        }
	        
	        if (isDuplicate) {
	            itemsInStore.remove(disc);
	            totalRemoved += 1;
	        }
	    }
	    
	    return totalRemoved > 0 ? totalRemoved : -1; // Trả về số lượng media đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	public void displayItems()
	{
		for(int i=0; i<itemsInStore.size(); i++)
		{
			itemsInStore.get(i).toString();
		}
	}
	
	public void displayItems(String title)
	{
		boolean check=false;
		for(Media media: itemsInStore)
		{
			if(media.getTitle().equals(title)) {
				media.toString();
				check=true;
			}
		}
		if(check==false) System.out.println("Media not found");
	}
	
	public Media isMatch(String title)
	{
		String[] strWords = title.split("[\\s,;.!]+");
		int nbMatch=0;
		
		for(String word: strWords)
		{
			for(int i=0; i<itemsInStore.size(); i++)
			{
				String[] strTitleWords = itemsInStore.get(i).getTitle().split("[\\s,;.!]+");
				for(String titleWord : strTitleWords)
				{
					if (titleWord.equals(word)) {
						nbMatch++;
						//System.out.print(nbMatch);
						//printInfoDVD(i);
						return(itemsInStore.get(i));
					}
				}
			}
		}
		if(nbMatch==0) {
			System.out.println("Media not found in the cart");
			return(null);
		}
		return(null);
	}
}
