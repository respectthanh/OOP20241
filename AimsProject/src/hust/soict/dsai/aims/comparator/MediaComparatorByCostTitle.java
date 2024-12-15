package hust.soict.dsai.aims.comparator;

import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media arg0, Media arg1) {
		if (arg0.getCost() == arg1.getCost()) {
			return arg0.getTitle().compareToIgnoreCase(arg1.getTitle());
		}
		else return (int)(arg1.getCost() - arg0.getCost());
	}

}