package hust.soict.hedspi.aims.media;
import java.util.Comparator;
// 20225651
public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
            return (int) -(o1.getCost() - o2.getCost());
        }
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
