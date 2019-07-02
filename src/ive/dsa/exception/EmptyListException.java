package ive.dsa.exception;

/**
 * It occurs when the list is empty and remove item from it.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class EmptyListException extends RuntimeException {
	// Constructor
	public EmptyListException() {
		super("List is empty.");
	}
}
