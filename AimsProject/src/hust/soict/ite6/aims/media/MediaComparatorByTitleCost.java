package hust.soict.ite6.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
		@Override
		public int compare(Media media1, Media media2)
		{
			int TitleCompare = media1.getTitle().compareTo(media2.getTitle());
			
			if (TitleCompare==0)
			{
				return Float.compare(media2.getCost(), media1.getCost());
			}
			return TitleCompare;
		}
		
}
