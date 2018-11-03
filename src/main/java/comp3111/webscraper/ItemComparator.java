package comp3111.webscraper;

import java.util.Comparator;

/**
 * @author awtang
 */
public class ItemComparator implements Comparator<Item> {
	@Override
    public int compare(Item i1, Item i2){
        int priceCmp = Double.compare(i1.getPrice(),i2.getPrice());
        if (priceCmp != 0) {
            return priceCmp;
        }
        if ((i1.getPortal() == "Amazon") && (i2.getPortal() == "Craigslist")) {
            return 1;
        }
        return 0;
    }
}
