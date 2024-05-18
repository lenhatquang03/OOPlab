package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.lang.Float;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public MediaComparatorByCostTitle() {}
    @Override
    public int compare(Media m1, Media m2) {
        int comparison = 0;
        comparison = Float.compare(m1.getCost(), m2.getCost());
        if (comparison == 0) {
            comparison = m1.getTitle().compareTo(m2.getTitle());
        }
        return comparison;
    }
}
