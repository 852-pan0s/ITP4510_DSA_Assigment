package ive.dsa.linklist;

import ive.dsa.exception.EmptyListException;

/**
 * This is a Linked List interface.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */
public interface InterLinkedList {

	/**
	 * Is it a empty list?
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Add item to the head of list
	 * 
	 * @param item
	 */
	public abstract void addToHead(Object item);

	/**
	 * Add item to the tail of list
	 * 
	 * @param item
	 */
	public abstract void addToTail(Object item);

	/**
	 * Remove head item.
	 * 
	 * @return
	 */
	public abstract Object removeFromHead() throws EmptyListException;

	/**
	 * Remove tail item.
	 * 
	 * @return
	 */
	public abstract Object removeFromTail() throws EmptyListException;

	/**
	 * Remove specific item.
	 * 
	 * @param item
	 * @throws ItemNotFoundException
	 */
	void removeItem(Object item) throws ItemNotFoundException;

	/**
	 * Add item to specific location.
	 * 
	 * @param item
	 * @param n
	 */
	void addItemAt(Object item, int n);

	/**
	 * @param move back one step.
	 * 
	 * @param item
	 */
	void swapNextItem(Object item);

	/**
	 * @param move back two steps.
	 * 
	 * @param item
	 */
	void moveBackTwo(Object item);

	/**
	 * This method will cut the linked list to three during running. Set itemA and
	 * itemB value, it will use them to choose items. The items which are after the
	 * first itemA/itemB will be SetA The items which are between the first
	 * itemA/itemB and the second itemA/itemB will be SetB (include itemA and itemB)
	 * The items which are after the second joker will be cardSetC Then, SetC will
	 * swap with SetA
	 * 
	 * @param itemA
	 * @param itemB
	 */
	void swapListedSetItem(Object itemA, Object itemB);

	/*
	 * Choose tail item and use its value as the range of choosing item. The chosen
	 * item will be place before the tail. If tail item is more than maxValue, it
	 * will not do anythings.
	 * 
	 * @param maxValue
	 */
	void insertToTailBefore(Object maxValue);

	/**
	 * Use head to get the item. if the head is more than maxValue, the head value
	 * will be maxValue's value.
	 * 
	 * @param maxValue
	 * @return
	 */

	Object getItemByHead(Object maxValue);

}
