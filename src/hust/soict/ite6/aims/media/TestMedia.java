package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class TestMedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		
		Media cdMedia= new CompactDisc("Vuong gia thien ha", "Animation", "Le Ly Muc", "Muc director", 60, 0.5f);
		Media dvdMedia = new DigitalVideoDisc("The Lion King", "Animation", "Roger allers", 65, 1.95f);
		Media bookMedia = new Book("Conan", "Fiction", "Aoyama Gosho");
		
		mediae.add(cdMedia);
		mediae.add(dvdMedia);
		mediae.add(bookMedia);
		
		for(Media m:mediae)
		{
			System.out.println(m.toString());
		}
	}

}
