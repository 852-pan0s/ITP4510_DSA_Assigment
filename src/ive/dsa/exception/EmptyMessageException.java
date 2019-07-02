package ive.dsa.exception;

/**
 * When the input message is emxpty, it occurs.
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 */

public class EmptyMessageException extends RuntimeException {
	// Constructor
	public EmptyMessageException() {
		super("<message_string> is empty.");
		// TODO Auto-generated constructor stub
	}

}
