package ive.dsa.linklist;

import ive.dsa.exception.EmptyListException;
import ive.dsa.solitaire.InterTripleCut;
import ive.dsa.solitaire.SolitaireTool;

/**
 * This is LinkedList class.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class LinkedList implements InterLinkedList {
	private ListCard head;
	private ListCard tail;
	private Comparator comparator;

	private interface InsertToTailBefore {
		void swapCardSet();
	}

	/**
	 * Constructor
	 */
	public LinkedList() {
		head = null;
		tail = null;
		comparator = new intComparator();
	}

	/**
	 * Get item index
	 * 
	 * @param item
	 * @return
	 * @throws ItemNotFoundException
	 */
	public int getItemIdx(Object item) throws ItemNotFoundException {
		int i = 0;
		ListCard current = head;
		try {
			while (!comparator.isEqualTo(current.data, item)) {
				current = current.next;
				i++;
			}
		} catch (NullPointerException e) {
			throw new ItemNotFoundException();
		}
		return i;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void addToHead(Object item) {
		if (isEmpty()) {
			head = tail = new ListCard(item);
		} else {
			head = new ListCard(item, head);
		}
	}

	@Override
	public void addToTail(Object item) {
		if (isEmpty()) {
			addToHead(item);
		} else {
			tail.next = new ListCard(item);
			tail = tail.next;
		}
	}

	@Override
	public Object removeFromHead() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		Object item = head.data;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		return item;
	}

	@Override
	public Object removeFromTail() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		Object item = tail.data;
		if (head == tail) {
			head = tail = null;
			return item;
		}
		ListCard current = head;
		while (current.next != tail)
			current = current.next;
		tail = current;
		tail.next = null;
		return item;
	}

	@Override
	public String toString() {
		String s = "[ ";
		ListCard current = head;
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s + "]";
	}

	@Override
	public void removeItem(Object item) throws ItemNotFoundException {
		if (isEmpty()) {
			throw new ItemNotFoundException();
		}
		if (comparator.isEqualTo(head.data, item))
			removeFromHead();
		else if (comparator.isEqualTo(tail.data, item))
			removeFromTail();
		else {
			ListCard current = head;
			while (current.next != null) {
				if (comparator.isEqualTo(current.next.data, item)) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
			throw new ItemNotFoundException();

		}
	}

	@Override
	public void addItemAt(Object item, int n) {
		if (isEmpty() || n == 0) {
			addToHead(item);
			return;
		}
		if (n >= SolitaireTool.cardSize) {
			addToTail(item);
			return;
		}
		int currentPos = 0;
		ListCard current = head;
		while (currentPos < (n - 1)) {
			current = current.next;
			currentPos++;
		}
		ListCard newNode = new ListCard(item);
		newNode.next = current.next;
		current.next = newNode;
	}

	@Override
	public void swapNextItem(Object item) {
		ListCard current = head;
		while (!(comparator.isEqualTo(current.data, item)) && current != null) {
			current = current.next;
		}
		Object tempItem = current.data;
		if (current == tail) {
			tempItem = tail.data;
			tail.data = head.data;
			head.data = tempItem;
		} else {
			tempItem = current.data;
			current.data = current.next.data;
			current.next.data = tempItem;
		}
	}

	@Override
	public void moveBackTwo(Object item) {
		final Object JOKER_B = item;
		new MoveBack() {
			@Override
			public void moveBack() {
				int step = (getItemIdx(JOKER_B) + 2) % ((int) JOKER_B);
				if(comparator.isEqualTo(tail.data, JOKER_B)) {
					removeItem(JOKER_B);
					Object temp = removeFromHead();
					addToTail(temp);
					addItemAt(JOKER_B, 1);
					return;
				}
				removeItem(JOKER_B);
				if (step == (int) JOKER_B - 1) {
					addToTail(JOKER_B);
				} else {
					if(step==0) {
						Object temp = removeFromHead();
						addToHead(JOKER_B);
						addToTail(temp);
					}else
						addItemAt(JOKER_B, step);
				}
			}
		}.moveBack();

	}

	@Override
	public void swapListedSetItem(Object itemA, Object itemB) {
		final Object JOKER_A = itemA;
		final Object JOKER_B = itemB;
		// Using local anonymous class to reduce the memory.
		new InterTripleCut() {
			public void tripleCut() {
				// If both head and tail = jokers, stop triple cut.
				if (isJoker(head.data) && isJoker(tail.data))
					return;
				// Create a new Linkedlist to store data.
				LinkedList ll = new LinkedList();
				while (!isJoker(head.data)) {
					// Add head data to ll.tail and remove head data.
					ll.addToTail(removeFromHead());
				}
				while (!isJoker(tail.data)) {
					// Add tail data to head data and remove tail data.
					addToHead(removeFromTail());
				}
				// Link the new linkedlist.
				tail.next = ll.head;
				if (ll.tail != null)
					// tail = new linkedlist tail.
					tail = ll.tail;

			}

			public boolean isJoker(Object position) {
				return (comparator.isEqualTo(position, JOKER_A) || comparator.isEqualTo(position, JOKER_B));
			}
		}.tripleCut();
	}

	@Override
	public void insertToTailBefore(Object max) {
		final Object maxValue = max;
		new InsertToTailBefore() {
			public void swapCardSet() {
				int jokerA = (int) tail.data;
				// If the last card is a joker, take the value as 27 no matter which joker it
				if (jokerA >= (int) maxValue) {
					return;
				}
				Object temp = removeFromTail();
				for (int i = 0; i < jokerA; i++) {
					addToTail(removeFromHead());
				}
				addToTail(temp);
			}
		}.swapCardSet();
	}

	@Override
	public Object getItemByHead(Object maxValue) {
		ListCard current = head;
		int startNo = (int) head.data;
		if (startNo >= (int) maxValue) {
			startNo = (int) maxValue;
		}
		for (int i = 0; i < startNo; i++) {
			current = current.next;
		}
		return current.data;
	}

}
