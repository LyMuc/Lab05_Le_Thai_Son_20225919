package hust.soict.hedspi.aims.media;
// 20225651
public class Disc extends Media implements Playable {
    private int length; // in seconds
    private String director; // director of the disc

    public Disc(String title, String category, float cost, int length, String director){
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(String title){
        super(title);
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    @Override
    public void print() {
        System.out.println("Disc - ID: " + getId() + " - Title: " 
            + getTitle() + " - Category: " + getCategory() + " - Director: " 
            + director + " - Length: " + length + " - Cost: " + getCost() + "$");
    }
    @Override
    public void play() {
    }
}
