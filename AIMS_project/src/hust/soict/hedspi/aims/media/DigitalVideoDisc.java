package hust.soict.hedspi.aims.media;

// 20225651

public class DigitalVideoDisc extends Disc {
    public DigitalVideoDisc(String title, String category, float cost, int length, String director){
        super(title, category, cost, length, director); 
    }
    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost){
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public void print() {
        System.out.println("DVD: id: " + this.getId() + " - Title: " + this.getTitle() + " - Category: " 
            + this.getCategory() + " - Director: " + this.getDirector() + " - Length: " + this.getLength() 
            + " - Cost: " + this.getCost() + " $");
    }
    @Override
    public String toString() {
        return "DVD: id: " + this.getId() + " - Title: " + this.getTitle() + " - Category: " 
            + this.getCategory() + " - Director: " + this.getDirector() + " - Length: " + this.getLength() 
            + " - Cost: " + this.getCost() + " $";
    }
    @Override
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc dvd) {

            // Compare by title (ascending order)
            int titleComparison = this.getTitle().compareTo(dvd.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }

            // Compare by length (decreasing order)
            int lengthComparison = Integer.compare(dvd.getLength(), this.getLength());
            if (lengthComparison != 0) {
                return lengthComparison;
            }

            // Compare by cost (decreasing order)
            return Float.compare(dvd.getCost(), this.getCost());
        }

        // Fall back to default comparison for other media types
        return super.compareTo(other);
    }

}