package ive.dsa.solitaire;

import ive.dsa.linklist.Comparator;
import ive.dsa.linklist.InterLinkedList;
import ive.dsa.linklist.LinkedList;
import ive.dsa.linklist.intComparator;

/**
 * The futher. This class is abstract, can not be implement. It provides its
 * descendants a cardSet.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */
public abstract class Solitaire {
	protected InterLinkedList ll;
	protected int[] cardSet;
	protected Comparator comparator;

	// Constructor
	protected Solitaire(int[] cardSet) {
		// TODO Auto-generated constructor stub
		this.cardSet = cardSet;
		ll = new LinkedList();
		comparator = new intComparator();
		cardSetInit();
	}

	// initialize the card set
	protected void cardSetInit() {
		for (int i : cardSet) {
			ll.addToTail(new Integer(i));
		}
	}

	// Print the card set
	public void printCardSet() {
		System.out.println(ll);
	}
}
