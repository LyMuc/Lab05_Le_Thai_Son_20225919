package hust.soict.hedspi.aims.media;

import java.util.*;

// 20225651

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost){
        super(title, category, cost);
    }
    public Book(String title){
        super(title);
    }
    public void AddAuthor(String authorName){
        if (authors.contains(authorName)){
            System.out.println("Author already exists");
        } else {
            authors.add(authorName);
            System.out.println("Author added");
        }
    }
    public void RemoveAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Author removed");
        } else {
            System.out.println("Author not found");
        }
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    @Override
    public void print() {
        System.out.print("Book - ID: " + getId() + " - Title: " 
            + getTitle() + " - Category: " + getCategory() + " - Author: ");
        for (String author : authors){
            System.out.print(author + ", ");
        }
        System.out.println(" - Cost: " + getCost() + "$");
    }
    @Override
    public String toString() {
        return "Book - ID: " + getId() + " - Title: " + getTitle() + " - Category: " 
            + getCategory() + " - Cost: " + getCost() + "$";
    }
}
