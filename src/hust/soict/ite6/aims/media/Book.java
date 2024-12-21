package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	public static final String notifySearchBook = "Book: ";
	public static int nbBooks =0;

	public Book(String title, String category, String authorName) w{
		this.title=title;
		this.category=category;
		// TODO Auto-generated constructor stub
		addAuthor(authorName);
		nbBooks++;
		this.id=nbBooks;
	}
	
	
	public boolean addAuthor(String authorName)
	{
		StringBuffer stringBuffer = new StringBuffer();
		if(authors.contains(authorName)==false)
		{
			authors.add(authorName);
			stringBuffer.append("The author ").append(authorName).append("has been added successfully");
			System.out.println(stringBuffer.toString());
			return(true);
		}
		else {
			stringBuffer.append("The author ").append(authorName).append("has already been added");
			return(false);
		}
	}
	
	public boolean removeAuthor(String authorName)
	{
		StringBuffer stringBuffer = new StringBuffer();
		if(authors.contains(authorName)==true)
		{
			authors.remove(authorName);
			stringBuffer.append("The author ").append(authorName).append("has been removed successfully");
			System.out.println(stringBuffer.toString());
			return(true);
		}
		else {
			stringBuffer.append("The author ").append(authorName).append("is not in the list");
			return(false);
		}
	}
	
	public String toString()
	{
		StringBuilder bookContentString = new StringBuilder(notifySearchBook);
	    bookContentString.append(String.valueOf(id))
	            .append(". Title: ").append(this.getTitle())
	            .append(" Category: ").append(this.getCategory())
	            .append(" Author list: ");
	    for(int i=0; i<authors.size(); i++)
	    {
	    	bookContentString.append(authors.get(i));
	    	bookContentString.append(", ");
	    }
	    
	    return bookContentString.toString();
	}
	
}
