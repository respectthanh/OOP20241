package hust.soict.dsai.aims.comparator;

import java.util.Comparator;
import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int titleCompare = o1.getTitle().compareToIgnoreCase(o2.getTitle());
		if (titleCompare != 0) return titleCompare;
		else return (int)(o2.getCost() - o1.getCost());
	}

}