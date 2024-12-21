package hust.soict.ite6.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED =20;
	public static final String strCartBillUpper = "***********************CART***********************";
	public static final String strCartBillBottom = "***************************************************";
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public int addMedia(Media... discs)
	{
		int totalAdded = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (Media disc : discs) {
	        if (itemsOrdered.size() == 20) {
	            System.out.println("The cart is full");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < itemsOrdered.size(); index++) {
	            if (itemsOrdered.get(index).getTitle().equals(disc.getTitle())) {
	                System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	        }
	        
	        if (!isDuplicate) {
	            itemsOrdered.add(disc);
	            totalAdded += 1;
	        }
	    }
	    
	    return totalAdded > 0 ? totalAdded : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	public int removeMedia(Media... discs)
	{
		int totalRemoved = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (Media disc : discs) {
	        if (itemsOrdered.size() == 0) {
	            System.out.println("The cart is empty");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < itemsOrdered.size(); index++) {
	            if (itemsOrdered.get(index).getTitle().equals(disc.getTitle())) {
	                //System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	            else System.out.println("The disc " + disc.getTitle() + " is not in the list");
	        }
	        
	        if (isDuplicate) {
	            itemsOrdered.remove(disc);
	            totalRemoved += 1;
	        }
	    }
	    
	    return totalRemoved > 0 ? totalRemoved : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}
	
	

	/*public int addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
	{	
		for(int i=0; i<dvdList.length; i++)
		{
			if(this.qtyOrdered==20){
				System.out.println("The cart is now full");
				return(-1);
			}
			DigitalVideoDisc disc=dvdList[i];
			for(int index=0;index < this.qtyOrdered; index++)
			{
				if(itemsOrdered[index].getTitle().equals(disc.getTitle())) {
					System.out.println("The disc " + disc.getTitle() + " has been added");
				}
				else {
					itemsOrdered[this.qtyOrdered]=disc;
					this.qtyOrdered+=1;
				}
			}
		}
		return(1);
	}*/
	
	/*public int addDigitalVideoDisc(DigitalVideoDisc... discs) {
	    int totalAdded = 0; // Biến để đếm số lượng DVD đã thêm thành công
	    for (DigitalVideoDisc disc : discs) {
	        if (this.qtyOrdered == 20) {
	            System.out.println("The cart is full");
	            break;
	        }
	        
	        // Kiểm tra trùng lặp DVD
	        boolean isDuplicate = false;
	        for (int index = 0; index < this.qtyOrdered; index++) {
	            if (itemsOrdered[index].getTitle().equals(disc.getTitle())) {
	                System.out.println("The disc " + disc.getTitle() + " has been added already");
	                isDuplicate = true;
	                break;
	            }
	        }
	        
	        if (!isDuplicate) {
	            itemsOrdered[this.qtyOrdered] = disc;
	            this.qtyOrdered += 1;
	            totalAdded += 1;
	        }
	    }
	    
	    return totalAdded > 0 ? totalAdded : -1; // Trả về số lượng DVD đã thêm hoặc -1 nếu không có DVD nào được thêm
	}*/

	
	
	public float totalCost()
	{
		float cost=0;
		for(int i=0; i<itemsOrdered.size(); i++)
		{
			cost+=itemsOrdered.get(i).getCost();
		}
		return(cost);
	}
	
	
	
	/*public void printCart()
	{
		System.out.println(strCartBillUpper);
		for(int i=0; i<qtyOrdered; i++)
		{
			System.out.print(i+1);
			printInfoDVD(i);
		}
		System.out.println("Total cost: "+ totalCost());
		System.out.println(strCartBillBottom);
	}
	
	public void printInfoDVD(int i)
	{
		System.out.println(". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getDirector() + " - "
					+ toString(itemsOrdered[i].getLength()) + ": " + toString(itemsOrdered[i].getCost()) );
	}
	*/
	/*public Media isMatch(String title)
	{
		String[] strWords = title.split("[\\s,;.!]+");
		int nbMatch=0;
		
		for(String word: strWords)
		{
			for(int i=0; i<itemsOrdered.size(); i++)
			{
				String[] strTitleWords = itemsOrdered.get(i).getTitle().split("[\\s,;.!]+");
				for(String titleWord : strTitleWords)
				{
					if (titleWord.equals(word)) {
						nbMatch++;
						//System.out.print(nbMatch);
						//printInfoDVD(i);
						return(itemsOrdered.get(i));
					}
				}
			}
		}
		if(nbMatch==0) {
			System.out.println("Media not found in the cart");
			return(false);
		}
		return(true);
	}*/
	
	/*public boolean isMatch(int id)
	{
		int nbMatch=0;
		for(int i=0; i<qtyOrdered; i++)
		{
			if(itemsOrdered[i].getId()==id)
			{
				nbMatch++;
				System.out.print(nbMatch);
				printInfoDVD(i);
			}
		}
		if(nbMatch==0) {
			System.out.println("Disc not found in the cart");
			return(false);
		}
		return(true);
	}*/
	
	/*public String toString(int cartBill)
	{
		String cartContent = String.valueOf(cartBill);
		return (cartContent);
	}
	
	public String toString(float cost)
	{
		String cartContent = String.valueOf(cost);
		return (cartContent);
	}*/
	
}
