package hust.soict.ite6.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	@Override
	public int compare(Media media1, Media media2)
	{
		int CostCompare = Float.compare(media2.getCost(), media1.getCost());
		
		if (CostCompare==0)
		{
			return media1.getTitle().compareTo(media2.getTitle());
		}
		return CostCompare;
	}
	
}
