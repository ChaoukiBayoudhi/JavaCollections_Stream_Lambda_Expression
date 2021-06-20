package CarPkg;

import java.util.Comparator;

public class CarComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Car)o1).getCode().compareToIgnoreCase(((Car)o2).getCode());
    }
}
