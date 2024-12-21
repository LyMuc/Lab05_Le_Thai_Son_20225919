package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public static final String notifySearchCD = "CD and its track: ";
	public static int nbCDs=0;
	
	public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(title, category, director, length, cost);
		this.artist=artist;
		this.id=nbCDs;
		nbCDs++;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public boolean addTrack(Track inpTrack)
	{
		StringBuffer stringBuffer = new StringBuffer();
		if(tracks.contains(inpTrack)==false)
		{
			tracks.add(inpTrack);
			stringBuffer.append("The track ").append(inpTrack.getTitle()).append("has been added successfully");
			System.out.println(stringBuffer.toString());
			return(true);
		}
		else {
			stringBuffer.append("The track ").append(inpTrack.getTitle()).append("has already been added");
			return(false);
		}
	}
	
	public boolean removeTrack(Track inpTrack)
	{
		StringBuffer stringBuffer = new StringBuffer();
		if(tracks.contains(inpTrack)==true)
		{
			tracks.remove(inpTrack);
			stringBuffer.append("The track ").append(inpTrack.getTitle()).append("has been removed successfully");
			System.out.println(stringBuffer.toString());
			return(true);
		}
		else {
			stringBuffer.append("The track ").append(inpTrack.getTitle()).append("is not in the list");
			return(false);
		}
	}
	
	@Override
	public int getLength()
	{
		int length=0;
		for(int i=0; i<tracks.size(); i++)
		{
			length+=tracks.get(i).getLength();
		}
		return(length);
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD category: " + this.getCategory());
		System.out.println("Artist: " + this.artist);
		System.out.println("Director: " + this.getDirector());
		System.out.println("CD length: " + this.getLength());
		System.out.println("Cost: " + this.getCost());
		
		for(int i=0; i<tracks.size(); i++) {
			tracks.get(i).play();
			System.out.println();
		}
	}
	
	public String toString()
	{
		StringBuilder cdContentString = new StringBuilder(notifySearchCD);
	    cdContentString.append(String.valueOf(id))
	            .append(". Title: ").append(this.getTitle())
	            .append(" Category: ").append(this.getCategory())
	            .append(" Artist: ").append(this.getArtist())
	            .append(" Director: ").append(this.getDirector())
	            .append(" Length: ").append(String.valueOf(this.getLength()))
	    	    .append(" Cost: ").append(String.valueOf(this.getCost()))
	            .append(" Track list: \n");
	    for(int i=0; i<tracks.size(); i++)
	    {
	    	cdContentString.append(tracks.get(i).getTitle());
	    	cdContentString.append(" ");
	    	cdContentString.append(tracks.get(i).getLength());
	    	cdContentString.append("\n");
	    }
	    
	    return cdContentString.toString();
	}
}
