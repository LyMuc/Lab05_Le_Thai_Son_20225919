package hust.soict.ite6.aims.media;

public class Disc extends Media{

	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public Disc() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Disc(String title, String category, String directory, int length, float cost) {
		super(title, category, cost);
		this.length=length;
		this.director=directory;
	}
	
}
