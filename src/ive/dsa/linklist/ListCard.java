package ive.dsa.linklist;

/**
 * The card list.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class ListCard {
	public Object data;
	public ListCard next;

	// Constructor
	public ListCard(Object data, ListCard next) {
		super();
		this.data = data;
		this.next = next;
	}

	// Constructor
	public ListCard(Object data) {
		super();
		this.data = data;
		this.next = null;
	}

}