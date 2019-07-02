package ive.dsa.linklist;

/**
 * This calss is for comparing itemA and iteamB.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */
public interface Comparator {
	/**
	 * item1 is equal to item2?
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	boolean isEqualTo(Object item1, Object item2);

	/**
	 * item1 is less than item2?
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	boolean isLessThan(Object item1, Object item2);

	/**
	 * item1 is less than or equal to item2?
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	boolean isLessThanOrEqualTo(Object item1, Object item2);

	/**
	 * item1 is greater than item2?
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	boolean isGreaterThan(Object item1, Object item2);

	/**
	 * item1 is greater than orequal to item2?
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	boolean isGreaterThanOrEqualTo(Object item1, Object item2);
}
