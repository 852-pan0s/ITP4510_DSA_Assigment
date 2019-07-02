package ive.dsa.linklist;

/**
 * Comparing two integer object.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class intComparator implements Comparator {

	@Override
	public boolean isEqualTo(Object item1, Object item2) {
		return ((Integer) item1).compareTo((Integer) item2) == 0;
	}

	@Override
	public boolean isLessThan(Object item1, Object item2) {
		return ((Integer) item1).compareTo((Integer) item2) < 0;
	}

	@Override
	public boolean isLessThanOrEqualTo(Object item1, Object item2) {
		return isLessThan(item1, item2) || isEqualTo(item1, item2);
	}

	@Override
	public boolean isGreaterThan(Object item1, Object item2) {
		return ((Integer) item1).compareTo((Integer) item2) > 0;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Object item1, Object item2) {
		return isGreaterThan(item1, item2) || isEqualTo(item1, item2);
	}

}
