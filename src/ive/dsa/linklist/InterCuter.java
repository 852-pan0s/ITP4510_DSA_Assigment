package ive.dsa.linklist;

/**
 * Interface for cuter
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public interface InterCuter {
	/**
	 * Store the cut card set
	 */
	void cutCardSet();

	/**
	 * Get the card get.
	 * 
	 * @return
	 */
	LinkedList getCardSet();

	/**
	 * Replace anther card set to the current card set.
	 * 
	 * @param cardSet
	 */
	public abstract void replaceCardSet(LinkedList cardSet);

	/**
	 * Connect the another card set to the current card set.
	 * 
	 * @param cardSet
	 */
	void connectCardSet(ListCard cardSet);
}
