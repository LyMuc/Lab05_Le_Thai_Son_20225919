package hust.soict.ite6.aims.media;

public class Track implements Playable{

	public Track() {
		// TODO Auto-generated constructor stub
	}
	
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public boolean equals(Object obj) {
		if(obj instanceof Track)
		{
			return this.title == ((Track) obj).title && this.length == ((Track) obj).length;
		}
		return(false);
	}


}
