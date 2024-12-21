package hust.soict.ite6.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDiscs =0;
	public static final String notifySearchDVDs = "DVDs: ";
	
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super(title, category, directory, length, cost);
		nbDigitalVideoDiscs++;
		this.id=nbDigitalVideoDiscs;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public String toString()
	{
		StringBuilder dvdContentString = new StringBuilder(notifySearchDVDs);
	    dvdContentString.append(String.valueOf(id))
	            .append(". Title: ").append(this.getTitle())
	            .append(" Category: ").append(this.getCategory())
	            .append(" Director: ").append(this.getDirector())
	            .append(" Length: ").append(this.getLength())
	            .append(" Cost: ").append(this.getCost());

	    return dvdContentString.toString();
	}

}
