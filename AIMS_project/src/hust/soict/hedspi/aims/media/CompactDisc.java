package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

// 20225651

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, 
                        int length, String director, String artist){
        super(title, category, cost, length, director); 
        this.artist = artist;
    }
    public CompactDisc(String title){
        super(title);
    }
    public CompactDisc(String title, String category, float cost){
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    // getter and setter
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    @Override public int getLength(){
        int length = 0;
        for (Track track : tracks){
            length += track.getLength();
        }
        setLength(length);
        return length;
    }
    public void addTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("Track is already in the list");
        } else {
            tracks.add(track);
            System.out.println("Track added");
        }
    }
    @Override public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
    }
    @Override public void print() {
        System.out.println("CD: id: " + this.getId() + " - Title: " + this.getTitle() + " - Category: " 
            + this.getCategory() + " - Director: " + this.getDirector() + " - Length: " + this.getLength() 
            + " - Cost: " + this.getCost() + " $");
    }
    @Override
    public String toString() {
        return "CD: id: " + this.getId() + " - Title: " + this.getTitle() + " - Category: " 
            + this.getCategory() + " - Director: " + this.getDirector() + " - Length: " + this.getLength() 
            + " - Cost: " + this.getCost() + " $" + " - Artist: " + this.getArtist();
    }
}
